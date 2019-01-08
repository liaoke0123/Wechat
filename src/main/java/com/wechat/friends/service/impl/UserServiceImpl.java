package com.wechat.friends.service.impl;

import com.wechat.friends.dao.UserRepository;
import com.wechat.friends.entity.User;
import com.wechat.friends.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by share on 2019/1/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(String name, String password) {
        if(name==null||password==null){
            System.out.println("用户名或密码不能为空");
        }
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
