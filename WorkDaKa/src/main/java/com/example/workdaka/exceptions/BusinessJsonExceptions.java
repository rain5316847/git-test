package com.example.workdaka.exceptions;

/**
 * 业务json类异常
* */
public class BusinessJsonExceptions extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private final String code;

    public BusinessJsonExceptions(String msg,String code){
        super(msg);
        this.code = code;
    }

    public String code(){
        return this.code;
    }
}
