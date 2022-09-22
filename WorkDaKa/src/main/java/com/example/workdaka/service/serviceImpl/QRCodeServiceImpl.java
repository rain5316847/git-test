package com.example.workdaka.service.serviceImpl;


import com.alibaba.fastjson.JSONObject;
import com.example.workdaka.service.IQRCodeService;
import com.example.workdaka.utils.HttpClient;
import com.example.workdaka.utils.R;
import com.google.zxing.*;

import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class QRCodeServiceImpl implements IQRCodeService {

    @Override
    //该方法适用于微信或钉钉等电脑软件右键识别图片的二维码，再根据识别出来的网页链接解析产品信息。
    public R QueryMsgWithQRCode(String url) {

        R r = R.of();

        //网址第一次解码之后的信息
        String decode = null;
        //截取”code=“之后的内容
        String interceptURL;
        //将”%25“替换为”%“
        String replacement;
        //二次解码之后的信息
        String secDecode = null;
        //产品编号，可做生成二维码用
        String goodsNo;
        //访问蜀云查询该产品信息的网址
        String interfaceMsg;

        if(url == null || ("").equals(url)){
            return r.error("请输入二维码识别之后的网址信息。");
        }
        try {
            decode = java.net.URLDecoder.decode(url, "UTF-8");
            log.info("decode:{}",decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // interceptURL = StringUtils.substringBefore((StringUtils.substringAfterLast(decode, "code=")),"\"}");
        interceptURL = (StringUtils.substringAfterLast(decode, "code="));
        log.info("interceptURL:{}",interceptURL);
        replacement = interceptURL.replaceAll("%25","%");
        log.info("replacement:{}",replacement);
        try {
            secDecode = java.net.URLDecoder.decode(replacement, "UTF-8");
            log.info("secDecode:{}",secDecode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        goodsNo = (StringUtils.substringAfterLast(secDecode,"/aax5.cn/")).substring(2);
        log.info("GoodsNo:{}",goodsNo);
        interfaceMsg = HttpClient.queryMsgWithQRCode(secDecode);
        log.info("interfaceMsg:{}",interfaceMsg);
        JSONObject jsonMsg = JSONObject.parseObject(interfaceMsg);

        r.put("该二维码解析的内容为",secDecode);
        r.put("该产品二维码为",goodsNo);
        r.put("该产品信息为",jsonMsg);

        return r;
    }

    @Override
    //该方法适用于本服务自行调用的产品信息查询，传入的内容不带网址信息，只有产品编码。
    public R QueryMsgWithoutQRCode(String decode) {
        R r = R.of();
        //产品编号，可做生成二维码用
        String goodsNo;
        //访问蜀云查询该产品信息的网址
        String interfaceMsg;
        goodsNo = (StringUtils.substringAfterLast(decode,"/AAX5.CN/")).substring(2);
        log.info("GoodsNo:{}",goodsNo);
        interfaceMsg = HttpClient.queryMsgWithQRCode(decode);
        log.info("interfaceMsg:{}",interfaceMsg);
        JSONObject jsonMsg = JSONObject.parseObject(interfaceMsg);

        r.put("该二维码解析的内容为",decode);
        r.put("该产品二维码为",goodsNo);
        r.put("该产品信息为",jsonMsg);

        return r;
    }

    @Override
    public R IdentifyQRCode(String url) throws IOException, NotFoundException {
        File file = new File(URLDecoder.decode(url,"utf-8"));
        MultiFormatReader formatReader = new MultiFormatReader();
        //读取指定的二维码文件
        BufferedImage bufferedImage = ImageIO.read(file);
        BinaryBitmap binaryBitmap= new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
        //定义二维码参数
        Map hints= new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        com.google.zxing.Result result = formatReader.decode(binaryBitmap, hints);
        //输出相关的二维码信息
        log.info("解析结果:{}",result.toString());
        log.info("二维码格式类型:{}",result.getBarcodeFormat());
        log.info("二维码文本内容:{}",result.getText());
        bufferedImage.flush();
        //返回信息
        R r = this.QueryMsgWithoutQRCode(result.toString());
        return r;
    }

    @Override
    public BufferedImage GenerateQRCode(String msg) {
        int width = 250; // 图像宽度
        int height = 250; // 图像高度
        Map<EncodeHintType, Object> hints = new HashMap<>();
        //内容编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //设置二维码边的空度，非负数
        hints.put(EncodeHintType.MARGIN, 1);
        //构建比特矩阵
        BitMatrix bitMatrix;
        BufferedImage bufferedImage = null;
        try {
            //形成比特矩阵。参数：信息，条形码格式（二维码），宽度，高度，编码参数（UTF-8编码，纠错等级高，矩阵）
            bitMatrix = new MultiFormatWriter().encode(msg, BarcodeFormat.QR_CODE, width, height, hints);
            //矩阵转化为图像
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);
            log.info("matrixToImageConfig:{}",matrixToImageConfig);
            bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);
            log.info("bufferedImage:{}",bufferedImage);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

}
