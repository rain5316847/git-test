package com.example.fastlocal;

import com.example.fastlocal.service.ITestCodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

@SpringBootTest
class FastLocalApplicationTests {

    @Autowired
    private ITestCodeService iTestCodeService;
    @Test
    void dmCodeTest() {

            iTestCodeService.queryDmCode();

    }



}
