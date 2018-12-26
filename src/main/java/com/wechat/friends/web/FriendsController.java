package com.wechat.friends.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/friends")
@Api(description="朋友圈")
public class FriendsController {


    @ApiOperation(value = "测试")
    @GetMapping("test/{id}")
    public Object updatePassword(@PathVariable String id)  {
        HashMap<String,String> map =  new HashMap<>();
        map.put("result",id);
        return map;
    }





}
