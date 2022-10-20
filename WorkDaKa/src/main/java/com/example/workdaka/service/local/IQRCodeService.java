package com.example.workdaka.service.local;

import com.alibaba.fastjson.JSONObject;
import com.example.workdaka.utils.R;
import com.google.zxing.NotFoundException;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface IQRCodeService {

    R queryMsgWithQRCode(String url) throws UnsupportedEncodingException;

    R queryMsgWithoutQRCode(String decode);

    R identifyQRCode(String url) throws IOException, NotFoundException;

    BufferedImage generateQRCode(String msg);

    Map<String,String> resolveWithURL(String URL) throws UnsupportedEncodingException;

    JSONObject queryInfoWithCode(String code);

}
