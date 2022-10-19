package com.example.workdaka.utils.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.workdaka.entity.local.ThisUser;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

//生成token
@Slf4j
public class TokenUtils {

    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    public static String getJWTToken(ThisUser thisUser) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        String token;
        log.info("userid:{},user:{}",thisUser.getId(),thisUser);

        /*
        iss: jwt签发者
        sub: jwt所面向的用户
        aud: 接收jwt的一方
        exp: jwt的过期时间，这个过期时间必须要大于签发时间
        nbf: 定义在什么时间之前，该jwt都是不可用的.
        iat: jwt的签发时间
        jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
        */

        token= JWT.create().withAudience(thisUser.getId()) // 将 user id 保存到 token 里面
                .withExpiresAt(date) //五分钟后token过期
                .sign(Algorithm.HMAC256(thisUser.getPwd())); // 以 password 作为 token 的密钥
        return token;
    }

}
