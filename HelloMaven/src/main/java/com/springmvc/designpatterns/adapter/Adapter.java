package com.springmvc.designpatterns.adapter;

public class Adapter implements NetToHub {
    public Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();
    }

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        Computer computer = new Computer();
        computer.shangwang(adapter);
    }
}
