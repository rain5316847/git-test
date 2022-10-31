package com.example.fastsichuan.utils.common;

import java.lang.reflect.Field;

public class ObjectUtils {

    public static boolean objectEmpty(Object object){
        if(object == null){
            return true;
        }else {
            return objCheckIsNull(object);
        }
    }

    public static boolean objCheckIsNull(Object object){
        Class<?> clazz = object.getClass(); // 得到类对象
        Field[] fields = clazz.getDeclaredFields(); // 得到所有属性
        boolean flag = true; //定义返回结果，默认为true
        for(Field field : fields){
            field.setAccessible(true);
            Object fieldValue = null;
            try {
                fieldValue = field.get(object); //得到属性值
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
            if(fieldValue != null){  //只要有一个属性值不为null 就返回false 表示对象不为null
                flag = false;
                break;
            }
        }
        return flag;
    }
}
