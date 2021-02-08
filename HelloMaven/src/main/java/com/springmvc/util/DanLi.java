package com.springmvc.util;

public class DanLi {
    private static class DanLiHolder{
        private static DanLi danli = new DanLi();
    }
    public static DanLi get(){
        return DanLiHolder.danli;
    }
}
