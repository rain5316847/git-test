package com.example.workdaka.service.local;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.workdaka.entity.local.ThisUser;
import com.example.workdaka.utils.R;

import java.util.List;

public interface IUserService extends IService<ThisUser> {

    R login(ThisUser thisUser);

    List<ThisUser> all(String name);

    ThisUser getUser(String userId);
}
