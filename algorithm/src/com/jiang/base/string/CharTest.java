package com.jiang.base.string;

import java.nio.charset.StandardCharsets;

public class CharTest {

    public static void main(String args[]){

        byte[] s = "中".getBytes(StandardCharsets.UTF_8);
        for(byte b:s){
            System.out.println(Integer.toHexString(Byte.toUnsignedInt(b))+" ");
        }

    }
}
