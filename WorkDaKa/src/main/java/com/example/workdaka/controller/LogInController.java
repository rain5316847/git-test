package com.example.workdaka.controller;

import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.workdaka.annotation.LoginToken;
import com.example.workdaka.entity.ThisUser;
import com.example.workdaka.mapper.UserMapper;
import com.example.workdaka.service.IUserService;
import com.example.workdaka.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Login")
public class LogInController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService iUserService;

    @PostMapping("/login")
    public R longin(@RequestBody ThisUser thisUser){
        log.info("thisUser是:{}",thisUser);
        return iUserService.login(thisUser);
    }

    @LoginToken
    @PostMapping("all")
    public List<ThisUser> all(String name){
        QueryWrapper<ThisUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        List<ThisUser> list = userMapper.selectList(queryWrapper);
        return list;
    }

    @LoginToken
    @PostMapping("/getMessage")
    public String getMessage(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    }

    @GetMapping("/hello")
    public String HelloWorld(){
        return "HelloWorld";
    }

}
