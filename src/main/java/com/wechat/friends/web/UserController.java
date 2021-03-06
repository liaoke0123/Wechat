package com.wechat.friends.web;

import com.wechat.friends.dto.UserDTO;
import com.wechat.friends.entity.User;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


/**
 * Created by share on 2019/1/8.
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户")
public class UserController {
    @Autowired
    UserService userService;

    //add a user
    @PostMapping
    public void add(@RequestBody(required = false) UserDTO userDTO) throws BusinessException {
        userService.addUser(userDTO.getName(),userDTO.getPassword());
    }
    //delete a user by id
    @DeleteMapping("/{id}")
    public void delete(String id) throws BusinessException {
        userService.delUser(id);
    }
    //update a user
    @PutMapping
    public void update(String id ,UserDTO userDTO) throws BusinessException {
        userService.updateUser(id,userDTO.getName(),userDTO.getPassword());
    }

    //list all users
    @GetMapping("list/{page}/{size}")
    public Page<User> listAll(@PathVariable("page") Integer page , @PathVariable("size")Integer size) throws BusinessException {
        //sort by id in asc
        Sort sort = new Sort(Sort.Direction.ASC,"id");

        Pageable pageable = new PageRequest(page-1,size,sort);

        Page<User> pages = userService.listAllUser(pageable);
        return pages;
    }

}
