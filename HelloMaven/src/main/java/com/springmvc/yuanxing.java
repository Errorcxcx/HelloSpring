package com.springmvc;

import java.util.Date;

public class yuanxing implements Cloneable{
    private String name;
    private int year ;
    private Date createDate;
    @Override
    protected Object clone() throws CloneNotSupportedException {
//        yuanxing y = (yuanxing) super.clone();
//        y.createDate = (Date)this.createDate.clone();
//        return y;
        return super.clone();
    }
    public yuanxing() {
    }
    public yuanxing(String name, Date createDate) {
        this.name = name;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "yuanxing{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", createDate=" + createDate +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        yuanxing y1 = new yuanxing("y1",date);
        y1.year = 100;
        yuanxing y2 = (yuanxing) y1.clone();
        y1.name = "sssssd";
        y1.year = 5000;
        y2.year  = 5442;
        date.setTime(22131231);

        System.out.println(y1.hashCode());
        System.out.println(y2.hashCode());
    }
}
