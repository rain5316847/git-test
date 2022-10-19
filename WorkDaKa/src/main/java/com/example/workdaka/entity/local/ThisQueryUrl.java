package com.example.workdaka.entity.local;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("this_query_url")
public class ThisQueryUrl {

    @TableId(type = IdType.ASSIGN_UUID)
    public String id;

    public String user;

    public String url;

    /*
    * 1：网址查询；2：解析内容查询；3：二维码查询
    */
    public int type;

    public String result;

    /*
    * 1：成功；2：失败
    */
    public int success;

    public ThisQueryUrl(String url,int type,String result,int success){
        this.url = url;
        this.type = type;
        this.result = result;
        this.success = success;
    }

    public ThisQueryUrl(String user,String url,int type,String result,int success){
        this.user = user;
        this.url = url;
        this.type = type;
        this.result = result;
        this.success = success;
    }

    public static ThisQueryUrl TestCreate(String url,int type,String result,int success){
        return new ThisQueryUrl(url,type,result,success);
    }

    public static ThisQueryUrl Create(String user,String url,int type,String result,int success){
        return new ThisQueryUrl(user,url,type,result,success);
    }


}
