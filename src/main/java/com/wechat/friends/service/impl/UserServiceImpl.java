package com.wechat.friends.service.impl;

import com.wechat.friends.dao.UserRepository;
import com.wechat.friends.entity.User;
import com.wechat.friends.exception.BusinessException;
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
    public User addUser(String name, String password) throws BusinessException {
        User user=new User();
        if(name==null||password==null){
            throw new BusinessException("name or password can not be empty",0,500);
        }
        user.setName(name);
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public void delUser(int id) throws BusinessException {
        if (!userRepository.existsById(id)) {
            throw new BusinessException("this id is not exists",0,500);
        }
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> listAllUser(Pageable pageable) throws BusinessException {
        Page<User> page = userRepository.findAll(pageable);
        return page;
    }

    @Override
    public void updateUser(int id,String name,String password) throws BusinessException {
        userRepository.queryById(id,name,password);
    }
}
