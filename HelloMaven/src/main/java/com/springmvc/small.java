package com.springmvc;

import junit.framework.AssertionFailedError;
import org.apache.ibatis.cache.CacheException;

import java.io.PrintWriter;
import java.io.StringWriter;


public class small extends AssertionFailedError {
    public small(String msg){
        super(msg);
    }

    public static void main(String[] args) {
        try{
           throw new small("sssssssssssssssssdwvfvfvfv");
        }catch (small e){
            System.out.println("捕捉到了");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
           System.out.println(sw.toString());
        }
    }
}
