package com.itheima.pojo;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_user")
public class User {

    @Id
    //主键回填
    @KeySql(useGeneratedKeys = true)
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearold() {
        return yearold;
    }

    public void setYearold(int yearold) {
        this.yearold = yearold;
    }
    @Column
    private int yearold;

}
