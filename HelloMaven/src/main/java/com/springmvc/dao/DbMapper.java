package com.springmvc.dao;

import com.springmvc.entity.Db;
import com.springmvc.entity.DbKey;

public interface DbMapper {
    int deleteByPrimaryKey(DbKey key);

    int insert(Db record);

    int insertSelective(Db record);

    Db selectByPrimaryKey(DbKey key);

    int updateByPrimaryKeySelective(Db record);

    int updateByPrimaryKey(Db record);
}