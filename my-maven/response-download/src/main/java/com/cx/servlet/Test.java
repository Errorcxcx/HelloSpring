package com.cx.servlet;

public class Test {

    public static void main(String[] args) {
//        ThreadLocal<String> threadLocal = new ThreadLocal();
//        AAA a = new AAA(threadLocal);
//        BBB b = new BBB(threadLocal);
//        a.start();
//        b.start();
        String a = "bvcccbvddbv";
        String[] strings = a.split("bv");
        System.out.println(strings[0]);
        System.out.println(strings[1]);
        System.out.println(strings[2]);
        System.out.println(strings.length);



    }
}

class AAA extends Thread{
    ThreadLocal threadLocal;
    public AAA(ThreadLocal threadLocal) {
        this.threadLocal = threadLocal;
    }

    @Override
    public void run() {
        threadLocal.set("ssssrrr");
        System.out.println(threadLocal.get());
        super.run();
    }
}
class BBB extends Thread{
    ThreadLocal threadLocal;
    public BBB(ThreadLocal threadLocal) {
        this.threadLocal = threadLocal;
    }
    @Override
    public void run() {
        threadLocal.set("dddddweed");
        System.out.println(threadLocal.get());
        super.run();
    }
}
