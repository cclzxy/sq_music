package com.example.demo.Service.User;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Pogo.SqxxUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper usermapper;

    @Override
    public List<SqxxUsers> FindAllUsers() {
        return usermapper.FindAllUsers();
    }

    @Override
    public SqxxUsers FindAuser(String username) {
        return usermapper.FindAuser(username);
    }

    @Override
    public Integer findusercount(String username, String userpassword) {
        return usermapper.findusercount(username,userpassword);
    }
}
