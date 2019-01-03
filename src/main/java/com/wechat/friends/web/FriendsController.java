package com.wechat.friends.web;


import com.wechat.friends.dto.FriendsDTO;
import com.wechat.friends.entity.Friend;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.service.FriendsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/friends")
@Api(description="朋友圈")
public class FriendsController {

	@Resource
    FriendsService friendsService;
	

    @ApiOperation(value = "测试")
    @GetMapping("test/{id}")
    public Object updatePassword(@PathVariable String id)  {
        HashMap<String,String> map =  new HashMap<>();
        map.put("result",id);
        return map;
    }
    
    @ApiOperation(value = "发布朋友圈")
    @PostMapping(value = "/createMoment",produces = "application/json;charset=UTF-8")
    public Object createMoment(@RequestBody FriendsDTO friendsDTO) throws BusinessException {
		Friend friend=friendsService.createOneMoment(friendsDTO.getContent(),friendsDTO.getIds());
        System.out.println(friendsDTO.getIds());
        HashMap<String,String> map =  new HashMap<>();
        map.put("friendId",friend.getId());
        return map;
    }





}
