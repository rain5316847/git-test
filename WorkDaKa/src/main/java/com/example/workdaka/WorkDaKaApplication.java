package com.example.workdaka;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
*nameGenerator = DefaultBeanNameGenerator.class.使spring扫描包时不使用类的名称为Bean，而使用“包名+类名”的方式注册Bean
*/
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, MybatisPlusAutoConfiguration.class})
@ServletComponentScan
@ComponentScan(nameGenerator = DefaultBeanNameGenerator.class)
public class WorkDaKaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkDaKaApplication.class, args);
    }

}
