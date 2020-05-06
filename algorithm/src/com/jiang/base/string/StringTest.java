package com.jiang.base.string;

import java.util.List;

public class StringTest {

    public static void main(String args[]){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i< 1<<20;i++){
            builder.append('A');
        }
        System.out.println(builder.toString());
    }

    public Boolean haha(List<Boolean> s){

        return true;
    }

//    public String haha(List<String> s){
//        return "aa";
//    }


}
