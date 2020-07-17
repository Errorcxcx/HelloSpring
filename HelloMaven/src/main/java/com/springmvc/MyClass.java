package com.springmvc;

public class MyClass {
    private MyEntity myEntity = null;

    public void  A(){
        System.out.println("我是MyClass");
        myEntity.Execute();
    }

    public MyEntity getMyEntity() {
        return myEntity;
    }

    public void setMyEntity(MyEntity myEntity) {
        this.myEntity = myEntity;
    }

}
