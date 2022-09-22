package com.example.workdaka.service;

import com.example.workdaka.utils.R;
import com.google.zxing.NotFoundException;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface IQRCodeService {

    R QueryMsgWithQRCode(String url);

    R QueryMsgWithoutQRCode(String decode);

    R IdentifyQRCode(String url) throws IOException, NotFoundException;

    BufferedImage GenerateQRCode(String msg);

}
