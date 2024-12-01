package com.example.mapper;

import com.example.entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 获取用户密码
     * @param username
     * @return
     */
    @Select("select Password from Users where Username = #{username}")
    String getPassword(String username);


    /**
     * 获取用户列表
     * @return
     */
    @Select("select * from Users")
    List<Users> getUsers();

    /**
     * 添加
     * @param user
     */
    @Insert("insert into Users(Username, Password, Email, Role, Status, CreatedAt) values(#{Username}, #{Password}, #{Email}, #{Role}, #{Status}, #{CreatedAt})")
    void addUser(Users user);

    /**
     * 更新
     * @param user
     */
    void updateUser(Users user);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    @Select("select * from Users where UserID = #{id}")
    Users getUserById(Long id);

    /**
     * 删除
     * @param id
     */
    @Delete("delete from Users where UserID = #{id}")
    void deleteUser(Long id);

    /**
     * 查询
     * @param user
     * @return
     */
    List<Users> query(Users user);
}
