package com.example.workdaka.service.local.serviceImpl;


import com.alibaba.fastjson.JSONObject;
import com.example.workdaka.entity.local.QueryQRCode;
import com.example.workdaka.entity.local.ThisQueryUrl;
import com.example.workdaka.service.local.IQRCodeService;
import com.example.workdaka.service.local.IThisQueryUrlService;
import com.example.workdaka.utils.Common.EmptyUtils;
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
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IThisQueryUrlService iThisQueryUrlService;

    /**
    * 根据二维码信息查询产品信息
    *@param queryQRCode 传入的产品类型（1 箱码；2 瓶码；）；传入查询类型（1：网址查询；2：解析内容查询；3：二维码查询；）
    *@return 返回产品信息
    * */
    @Override
    public R queryMsgWithQRCode(QueryQRCode queryQRCode) {

        R r = R.of();
        Map<String, String> map = new HashMap<>();
        JSONObject data = new JSONObject();

        if(queryQRCode.getProduct().equals("1")){
            if(queryQRCode.getType().equals("1")) {
                try {
                    map = this.resolveWithURL(queryQRCode.getCode());
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            r.put("该二维码解析的内容为", map.get("该二维码解析的内容为"));
            r.put("该产品二维码为",map.get("该产品二维码为"));
        }
        else if(queryQRCode.getProduct().equals("2")){
            if(queryQRCode.getType().equals("1")) {
                try {
                    map = this.resolveWithURL(queryQRCode.getCode());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String code = map.get("该二维码解析的内容为");
                data = this.parseJSON(this.queryInfoWithCode(code));
                r.put("该二维码解析的内容为",map.get("该二维码解析的内容为"));
            }
            else if(queryQRCode.getType().equals("2")) {
                data = this.parseJSON(this.queryInfoWithCode(queryQRCode.getCode()));
            }
            r.put("data",data);
        }
        iThisQueryUrlService.insertUrlAndInfo(r.getData(),queryQRCode);
        return r;
    }

    /**
     * 根据网址解码查询解析结果
     * @param URL 根据电脑微信等右键识别二维码查询出来的网页地址
     * @return 返回二次解码之后的信息（手机“扫一扫pro识别的信息格式”）和箱码编号（可作为箱码查询使用）
     * */
    @Override
    public Map<String, String> resolveWithURL(String URL) throws UnsupportedEncodingException {

        Map<String,String> result = new HashMap<>();

        //网址第一次解码之后的信息
        String decode = null;
        //截取”code=“之后的内容
        String interceptURL;
        //将”%25“替换为”%“
        String replacement;
        //二次解码之后的信息，可做生成二维码用
        String secDecode;
        //产品编号
        String goodsNo;

        try {
            decode = java.net.URLDecoder.decode(URL, "UTF-8");
            log.info("decode:{}",decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        interceptURL = (StringUtils.substringAfterLast(decode, "code="));
        log.info("interceptURL:{}",interceptURL);
        replacement = interceptURL.replaceAll("%25","%");
        log.info("replacement:{}",replacement);
        secDecode = java.net.URLDecoder.decode(replacement, "UTF-8");
        log.info("secDecode:{}",secDecode);
        goodsNo = (StringUtils.substringAfterLast(secDecode,"/aax5.cn/")).substring(2);
        log.info("goodsNo:{}",goodsNo);

        result.put("该二维码解析的内容为",secDecode);
        result.put("该产品二维码为",goodsNo);
        return result;
    }

    /**
    * 根据“该二维码解析的内容”通过蜀云接口查询产品信息
    * @param code 二次解码之后的内容
    * @return 返回从蜀云接口查到的信息
    * */
    @Override
    public JSONObject queryInfoWithCode(String code) {
        //访问蜀云查询该产品信息的网址
        String interfaceMsg = HttpClient.queryMsgWithQRCode(code);
        log.info("interfaceMsg:{}",interfaceMsg);
        JSONObject jsonMsg = JSONObject.parseObject(interfaceMsg);
        return jsonMsg;
    }

    /**
    * 解析蜀云接口传过来的json数据
    * @param json 蜀云接口查询的瓶盖json数据
    * @return 返回一个解析过的JSONObject格式的纯瓶盖json数据
    * */
    @Override
    public JSONObject parseJSON(JSONObject json) {

        String outerDataStr = json.getString("data");
        //log.info("================outerData:{}==================",outerDataStr);
        JSONObject outerData = JSONObject.parseObject(outerDataStr);

        String innerDataStr = outerData.getString("data");
        //log.info("================innerDataStr:{}==================",innerDataStr);
        JSONObject innerData = JSONObject.parseObject(innerDataStr);

        return innerData;
    }



    @Override
    //该方法适用于微信或钉钉等电脑软件右键识别图片的二维码，再根据识别出来的网页链接解析产品信息。
    public R queryMsgWithQRCode(String url) throws UnsupportedEncodingException {

        R r = R.of();

        //网址第一次解码之后的信息
        String decode = null;
        //截取”code=“之后的内容
        String interceptURL;
        //将”%25“替换为”%“
        String replacement;
        //二次解码之后的信息
        String secDecode;
        //产品编号，可做生成二维码用
        String goodsNo;
        //访问蜀云查询该产品信息的网址
        String interfaceMsg = null;
        //本次查询是否成功
        int success = 1;

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
        secDecode = java.net.URLDecoder.decode(replacement, "UTF-8");
        log.info("secDecode:{}",secDecode);
        goodsNo = (StringUtils.substringAfterLast(secDecode,"/aax5.cn/")).substring(2);
        log.info("goodsNo:{}",goodsNo);

        try{
            interfaceMsg = HttpClient.queryMsgWithQRCode(secDecode);
        } catch (Exception e) {
            e.printStackTrace();
            success = 2;
           // iThisQueryUrlService.insertQueryUrl(new ThisQueryUrl(url,1,r.toString(),success));
        }

        log.info("interfaceMsg:{}",interfaceMsg);
        JSONObject capMsg = this.parseJSON(JSONObject.parseObject(interfaceMsg));
        r.put("该二维码解析的内容为",secDecode);
        r.put("该产品二维码为",goodsNo);
        r.put("该产品信息为",capMsg);

        //iThisQueryUrlService.insertQueryUrl(new ThisQueryUrl(url,1,r.toString(),success));

        return r;
    }

    @Override
    //根据解析结果查询产品信息。
    public R queryMsgWithoutQRCode(String decode) {

        R r = R.of();
        //产品编号，可做生成二维码用
        String goodsNo;
        //访问蜀云查询该产品信息的网址
        String interfaceMsg = null;
        //本次查询是否成功
        int success = 1;

        goodsNo = (StringUtils.substringAfterLast(decode,"/AAX5.CN/")).substring(2);
        log.info("GoodsNo:{}",goodsNo);

        try{
            interfaceMsg = HttpClient.queryMsgWithQRCode(decode);
        } catch (Exception e) {
            e.printStackTrace();
            success = 2;
           // iThisQueryUrlService.insertQueryUrl(new ThisQueryUrl(decode,2,r.toString(),success));
        }

        log.info("interfaceMsg:{}",interfaceMsg);
        JSONObject jsonMsg = JSONObject.parseObject(interfaceMsg);

        r.put("该二维码解析的内容为",decode);
        r.put("该产品二维码为",goodsNo);
        r.put("该产品信息为",jsonMsg);

       // iThisQueryUrlService.insertQueryUrl(new ThisQueryUrl(decode,2,r.toString(),success));

        return r;
    }

    @Override
    //通过二维码查询产品信息。
    public R identifyQRCode(String url) throws IOException, NotFoundException {

        R r = R.of();
        //本次查询是否成功
        int success = 1;

        com.google.zxing.Result result;

        File file = new File(URLDecoder.decode(url,"utf-8"));
        MultiFormatReader formatReader = new MultiFormatReader();
        //读取指定的二维码文件
        BufferedImage bufferedImage = ImageIO.read(file);
        BinaryBitmap binaryBitmap= new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
        //定义二维码参数
        Map hints= new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        result = formatReader.decode(binaryBitmap, hints);

        //输出相关的二维码信息
        log.info("解析结果:{}",result.toString());
        log.info("二维码格式类型:{}",result.getBarcodeFormat());
        log.info("二维码文本内容:{}",result.getText());
        bufferedImage.flush();

        //返回信息
        try{
            r = this.queryMsgWithoutQRCode(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
            success = 2;
          //  iThisQueryUrlService.insertQueryUrl(new ThisQueryUrl(url,3,r.toString(),success));
        }

      //  iThisQueryUrlService.insertQueryUrl(new ThisQueryUrl(url,3,r.toString(),success));

        return r;
    }

    @Override
    //生成二维码
    public BufferedImage generateQRCode(String msg) {
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
        BufferedImage bufferedImage;
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
