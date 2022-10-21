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
    private String id;

    private String user;

    private String url;

    /*
    * 产品类型（1：箱码；2：瓶码）
    * */
    private String productType;

    /*
     * 查询类型（1：网址查询；2：解析内容查询；3：二维码查询)
     */
    private String type;

    private String result;

    /*
    * 1：成功；2：失败
    */
    private int success;

    /*public ThisQueryUrl(String url,int type,String result,int success){
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
*/

    public ThisQueryUrl(String id,String url,String type,String productType,String result){
        this.id = id;
        this.url = url;
        this.type = type;
        this.productType = productType;
        this.result = result;
    }

    public ThisQueryUrl(String id,String user,String url,String type,String productType,String result){
        this.id = id;
        this.user = user;
        this.url = url;
        this.type = type;
        this.productType = productType;
        this.result = result;
    }

    public static ThisQueryUrl create(String id,String url,String type,String productType,String result){
        return new ThisQueryUrl(id,url,type,productType,result);
    }

    public static ThisQueryUrl create(String id,String user,String url,String type,String productType,String result){
        return new ThisQueryUrl(id,user,url,type,productType,result);
    }


}
