package com.wechat.friends.service;


import com.wechat.friends.entity.Reply;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.ReplyState;
import org.springframework.data.domain.Page;

public interface RepliesService {

	Reply createOneReplyByUser (String content, String myUser_id,String replier_id,String friend_id) throws BusinessException;
	
	Reply getOneReply (String id, ReplyState replyState) throws BusinessException;
	
	Page<Reply> getAllReplys (ReplyState replyState,String friend_id, int pageSize, int pageNum) throws BusinessException;
	
	void deleteOneReply (String id) throws BusinessException;

}
