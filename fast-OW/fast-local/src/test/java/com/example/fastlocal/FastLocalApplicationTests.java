package com.example.fastlocal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

@SpringBootTest
class FastLocalApplicationTests {

    @Test
    void contextLoads() {

            String springVersion = SpringVersion.getVersion();
            String springBootVersion = SpringBootVersion.getVersion();
            System.out.println("Spring版本:"+springVersion+"\nSpringBoot版本:"+springBootVersion);

    }



}
