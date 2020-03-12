package com.example.demo.Mapper;

import com.example.demo.Pogo.SqxxUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //查询所有的用户
    @Select("select * from sqxx_users")
    List<SqxxUsers> FindAllUsers();
    //根据用户名查询用户
    @Select("select username,userpassword from sqxx_users where username=#{username}")
    SqxxUsers FindAuser(String username);
    //查询用户是否存在，返回数量
    @Select("select count(1) from sqxx_users where username=#{username} and userpassword=#{userpassword}")
    Integer findusercount(String username,String userpassword);
}
