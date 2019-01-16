package com.wechat.friends.service;


import com.wechat.friends.entity.Comment;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.CommentState;
import org.springframework.data.domain.Page;

public interface CommentsService {

	Comment createOneCommentByUser(String content,String user_id,String friend_id) throws BusinessException;
	
	Comment getOneComment(String id, CommentState commentState) throws BusinessException;
	
	Page<Comment> getAllComments(CommentState commentState, String friend_id, int pageSize, int pageNum) throws BusinessException;
	
	void deleteOneComment(String id) throws BusinessException;

}
