package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 获取用户密码
     * @param username
     * @return
     */
    @Select("select Password from Users where Username = #{username}")
    String getPassword(String username);


}
