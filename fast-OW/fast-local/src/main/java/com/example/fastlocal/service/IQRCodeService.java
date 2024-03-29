package com.example.fastlocal.service;

import com.alibaba.fastjson.JSONObject;
import com.example.fastlocal.entity.QueryQRCode;
import com.example.fastlocal.utils.R;
import com.google.zxing.NotFoundException;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface IQRCodeService {

    R queryMsgWithQRCode(QueryQRCode queryQRCode);

    Map<String,String> resolveWithURL(String URL) throws UnsupportedEncodingException;

    JSONObject queryInfoWithCode(String code) throws UnsupportedEncodingException;

    JSONObject parseJSON(JSONObject json);

    String interceptURl(String url);

    R queryMsgWithQRCode(String url) throws UnsupportedEncodingException;

    R queryMsgWithoutQRCode(String decode);

    R identifyQRCode(String url) throws IOException, NotFoundException;

    BufferedImage generateQRCode(String msg);

    R getQRMsgWithId(String id);

}
