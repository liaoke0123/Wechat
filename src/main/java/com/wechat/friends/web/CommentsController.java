package com.wechat.friends.web;


import com.wechat.friends.dto.CommentsDTO;
import com.wechat.friends.entity.Comment;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.CommentState;
import com.wechat.friends.service.CommentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
	
	@ApiOperation(value = "通过id获取一条评论")
	@GetMapping(value = "/getCommentByID",produces = "application/json;charset=UTF-8")
	public Object getCommentByIdAndCommentState(String id,@RequestParam("commentState") CommentState commentState) throws BusinessException{
		return commentService.getOneComment(id,commentState);
	}
	
	@ApiOperation(value = "获取所有评论并分页显示")
	@GetMapping(value = "/getAllComments",produces = "application/json;charset=UTF-8")
	public Object getAllCommentsByCommentStateAndFriend(@RequestParam("commentState") CommentState commentState, @RequestParam("friend_id")String friend_id,int pageSize,int pageNum) throws BusinessException{
		Page<Comment> comments=commentService.getAllComments(commentState, friend_id,pageSize,pageNum);
		return comments;
	}
	
}
