package com.example.fastlocal.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fastlocal.entity.ThisUser;
import com.example.fastlocal.mapper.UserMapper;
import com.example.fastlocal.service.IUserService;
import com.example.fastlocal.utils.R;
import com.example.fastlocal.utils.token.TokenUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, ThisUser> implements IUserService {

    @Override
    public R login(ThisUser thisUser) {
        R r = R.of();
        List<ThisUser> list;
        QueryWrapper<ThisUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",thisUser.getName());

        list = baseMapper.selectList(queryWrapper);
        if(list == null || list.size() == 0){
            r.put("login","00");
            r.setMsg("无此用户");
        }
        else if(list != null && list.size() > 0){
            ThisUser thisUser1 = list.get(0);
            String token = TokenUtils.getJWTToken(thisUser1);
            if(thisUser.getPwd().equals(thisUser1.getPwd())){
                r.setMsg("登陆成功");
                r.put("login","02");
                r.put("token",token);
                r.put("userID",thisUser1.getId());
            }
            else {
                r.setMsg("用户名或密码错误");
                r.put("login","01");
            }
        }
        return r;
    }

    @Override
    public List<ThisUser> all() {
        QueryWrapper<ThisUser> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq("name",name);
        List<ThisUser> list = baseMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public ThisUser getUser(String userId) {
        if(userId != null || !(("").equals(userId))){
            QueryWrapper<ThisUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",userId);
            return baseMapper.selectOne(queryWrapper);
        }
        else {
            return null;
        }
    }
}
