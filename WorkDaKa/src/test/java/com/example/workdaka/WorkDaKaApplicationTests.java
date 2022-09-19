package com.example.workdaka;

import com.example.workdaka.entity.ThisUser;
import com.example.workdaka.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.util.Map;

@SpringBootTest
class WorkDaKaApplicationTests {

    @Autowired
    private IUserService iUserService;

@Test
void all(){
    ThisUser thisUser = new ThisUser();
    thisUser.setName("llt");
    thisUser.setPwd("1");
    System.out.println(iUserService.login(thisUser));
}

}

