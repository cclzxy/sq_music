package com.example.demo.Service.User;

import com.example.demo.Pogo.SqxxUsers;

import java.util.List;

public interface UserService {
    List<SqxxUsers> FindAllUsers();
    SqxxUsers FindAuser(String username);
    Integer findusercount(String username,String userpassword);
}
