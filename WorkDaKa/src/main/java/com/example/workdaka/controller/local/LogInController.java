package com.example.workdaka.controller.local;

import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.workdaka.annotation.LoginToken;
import com.example.workdaka.entity.local.ThisUser;
import com.example.workdaka.mapper.local.UserMapper;
import com.example.workdaka.service.local.IHttpService;
import com.example.workdaka.service.local.IUserService;
import com.example.workdaka.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Login")
public class LogInController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IHttpService iHttpService;

    @PostMapping("/login")
    public R longin(@RequestBody ThisUser thisUser,HttpServletRequest httpServletRequest) throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        log.info("thisUser是:{}",thisUser);
        iHttpService.getRequestMsg(httpServletRequest);
        stopWatch.stop();
        log.info("=========={}方法请求时间是：{}============",
                "iHttpService.getRequestMsg(httpServletRequest)",
                stopWatch.getTotalTimeSeconds());
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
