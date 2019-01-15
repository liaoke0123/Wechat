package com.wechat.friends.web;


import com.wechat.friends.dto.FriendsDTO;
import com.wechat.friends.entity.Friend;
import com.wechat.friends.entity.Image;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.FriendState;
import com.wechat.friends.service.FriendsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Consumer;

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
    
    @Deprecated  //此方法将被弃用，不建议使用
    @ApiOperation(value = "发布朋友圈")
    @PostMapping(value = "/createMoment",produces = "application/json;charset=UTF-8")
    public Object createMoment(@RequestBody FriendsDTO friendsDTO) throws BusinessException {
		Friend friend=friendsService.createOneMoment(friendsDTO.getContent(),friendsDTO.getIds());
        HashMap<String,String> map =  new HashMap<>();
        map.put("friendId",friend.getId());
        return map;
    }
    
    @ApiOperation(value = "用户发布朋友圈")
    @PostMapping(value = "/createMomentByUser",produces = "application/json;charset=UTF-8")
    public Object createMoment(@RequestBody FriendsDTO friendsDTO,String user_id) throws BusinessException {
		Friend friend=friendsService.createOneMomentByUser(friendsDTO.getContent(),friendsDTO.getIds(),user_id);
        HashMap<String,String> map =  new HashMap<>();
        map.put("friendId",friend.getId());
        return map;
    }
	
	@ApiOperation(value = "通过id获取一条朋友圈")
	@GetMapping(value = "/getMomentByID",produces = "application/json;charset=UTF-8")
	public Object getMomentByIdAndFriendState(String id,@RequestParam("friendState") FriendState friendState) throws BusinessException{
		return friendsService.getOneMoment(id,friendState);
	}
	
	@ApiOperation(value = "获取所有朋友圈并分页显示")
	@GetMapping(value = "/getAllMoments",produces = "application/json;charset=UTF-8")
	public Object getAllCommentsByFriendState(@RequestParam("friendState") FriendState friendState,int pageSize,int pageNum) throws BusinessException{
		Page<Friend> friends=friendsService.getAllMoments(friendState,pageSize,pageNum);
		return friends;
	}
	
	@ApiOperation(value = "通过id删除朋友圈")
	@DeleteMapping(value = "/deleteMoment/{id}")
	public void deleteFileByID(@PathVariable String id) throws BusinessException {
		friendsService.deleteOneMoment(id);
	}

}
