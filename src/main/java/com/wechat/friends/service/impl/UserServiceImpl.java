package com.wechat.friends.service.impl;

import com.wechat.friends.dao.UserRepository;
import com.wechat.friends.entity.User;
import com.wechat.friends.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void delUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> listAllUser(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);
        return page;
    }

    @Override
    public void updateUser(int id,String name,String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userRepository.queryById(id,name,password);
    }
}
