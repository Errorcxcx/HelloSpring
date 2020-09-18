package com.itheima.mappers;

import com.itheima.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

//@Mapper
@Repository
public interface UserMapper extends Mapper<User> {
}
