package com.wechat.friends.web;


import com.wechat.friends.dto.RepliesDTO;
import com.wechat.friends.entity.Reply;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.ReplyState;
import com.wechat.friends.service.RepliesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/replies")
@Api(description="回复")
public class ReplyController {

	@Resource
	RepliesService repliesService;
	
	@ApiOperation(value = "用户回复评论")
	@PostMapping(value = "/createReplyByUser", produces = "application/json;charset=UTF-8")
	public Object createOneCommentByUser (@RequestBody RepliesDTO repliesDTO) throws BusinessException {
		Reply reply = repliesService.createOneReplyByUser(repliesDTO.getReplyContent(), repliesDTO.getComment_id(),repliesDTO.getReplier_id());
		
		RepliesDTO rDTO=new RepliesDTO();
		rDTO.setReply_id(reply.getId());
		rDTO.setReplyContent(reply.getReplyContent());
		rDTO.setComment_id(reply.getComment().getId()); //评论id
		rDTO.setCommentator_id(reply.getComment().getUser().getId()); //评论人id
		rDTO.setCommentator(reply.getComment().getUser().getName()); //评论人
		rDTO.setReplier_id(reply.getUser().getId()); //回复人id
		rDTO.setReplier(reply.getUser().getName()); //回复人
		return rDTO;
	}
	
	@ApiOperation(value = "通过id获取一条回复")
	@GetMapping(value = "/getReplyById",produces = "application/json;charset=UTF-8")
	public Object getCommentByIdAndCommentState(String id,@RequestParam("replyState") ReplyState replyState) throws BusinessException{
		Reply reply=repliesService.getOneReply(id,replyState);
		HashMap<String, String> map = new HashMap<>();
		map.put("commentContent",reply.getComment().getCommentContent());
		map.put("replyContent", reply.getReplyContent());
		return map;
	}
	
	@ApiOperation(value = "获取所有评论并分页显示")
	@GetMapping(value = "/getAllReplies",produces = "application/json;charset=UTF-8")
	public Object getAllRepliesByReplyStateAndComment(@RequestParam("replyState") ReplyState replyState, @RequestParam("comment_id")String comment_id,int pageSize,int pageNum) throws BusinessException{
		Page<Reply> replies=repliesService.getAllReplys(replyState, comment_id,pageSize,pageNum);
		return replies;
	}
	
	@ApiOperation(value = "通过id删除评论")
	@DeleteMapping(value = "/deleteReply/{id}")
	public void deleteReplyById(@PathVariable String id) throws BusinessException {
		repliesService.deleteOneReply(id);
	}

}
