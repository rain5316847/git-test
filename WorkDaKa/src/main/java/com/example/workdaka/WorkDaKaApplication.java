package com.example.workdaka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WorkDaKaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkDaKaApplication.class, args);
    }

}
