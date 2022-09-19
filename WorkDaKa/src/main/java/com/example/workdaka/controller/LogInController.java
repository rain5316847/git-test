package com.example.workdaka.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.workdaka.entity.ThisUser;
import com.example.workdaka.mapper.UserMapper;
import com.example.workdaka.service.IUserService;
import com.example.workdaka.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Login")
public class LogInController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService iUserService;

    @PostMapping("/login")
    public R longin(@RequestBody ThisUser thisUser){
        System.out.println("thisUser是："+thisUser);
        return iUserService.login(thisUser);
    }

    @PostMapping("all")
    public List<ThisUser> all(String name){
        QueryWrapper<ThisUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        List<ThisUser> list = userMapper.selectList(queryWrapper);
        return list;
    }

}
