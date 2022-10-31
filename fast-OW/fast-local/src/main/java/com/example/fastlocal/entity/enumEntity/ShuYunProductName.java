package com.example.fastlocal.entity.enumEntity;


public enum ShuYunProductName {

     p ("箱码"),
     c ("瓶码");

     private String name;

     private ShuYunProductName(String name){
         this.name = name;
     }

     public String getPName(){
        return this.name;
     }

    public void setPName(String name){
        this.name = name;
    }

}
