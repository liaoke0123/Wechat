package com.wechat.friends.service;


import com.wechat.friends.entity.Comment;
import com.wechat.friends.exception.BusinessException;

public interface CommentsService {

	Comment createOneCommentByUser(String content,String user_id,String friend_id) throws BusinessException;
	
	//TODO 评论查询

}
