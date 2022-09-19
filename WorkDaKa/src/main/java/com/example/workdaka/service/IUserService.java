package com.example.workdaka.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.ThisUser;
import com.example.workdaka.utils.R;

import java.util.List;

public interface IUserService extends IService<ThisUser> {

    R login(ThisUser thisUser);
    List<ThisUser> all(String name);
}
