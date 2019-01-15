package com.wechat.friends.web;


import com.wechat.friends.dto.CommentsDTO;
import com.wechat.friends.entity.Comment;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.service.CommentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/comments")
@Api(description="评论")
public class CommentsController {
	
	@Resource
	CommentsService commentService;
	
	@ApiOperation(value = "用户评论朋友圈")
	@PostMapping(value = "/createCommentByUser", produces = "application/json;charset=UTF-8")
	public Object createOneCommentByUser (@RequestBody CommentsDTO commentDTO, String user_id, String friend_id) throws BusinessException {
		Comment comment = commentService.createOneCommentByUser(commentDTO.getCommentContent(), user_id, friend_id);
		HashMap<String, String> map = new HashMap<>();
		map.put("commentId", comment.getId());
		return map;
	}
	
}
