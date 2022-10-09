package com.example.workdaka.service;

import com.example.workdaka.utils.R;
import com.google.zxing.NotFoundException;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface IQRCodeService {

    R queryMsgWithQRCode(String url) throws UnsupportedEncodingException;

    R queryMsgWithoutQRCode(String decode);

    R identifyQRCode(String url) throws IOException, NotFoundException;

    BufferedImage generateQRCode(String msg);

}
