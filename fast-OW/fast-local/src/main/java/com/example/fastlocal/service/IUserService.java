package com.example.fastlocal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fastlocal.entity.ThisUser;
import com.example.fastlocal.utils.R;

import java.util.List;

public interface IUserService extends IService<ThisUser> {

    R login(ThisUser thisUser);

    List<ThisUser> all();

    ThisUser getUser(String userId);
}
