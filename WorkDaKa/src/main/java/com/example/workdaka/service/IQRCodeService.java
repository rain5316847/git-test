package com.example.workdaka.service;

import com.example.workdaka.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

public interface IQRCodeService {

    R QueryMsgWithQRCode(String url);

}
