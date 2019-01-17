package com.wechat.friends.service.impl;

import com.wechat.friends.dao.CommentRepository;
import com.wechat.friends.dao.ReplyRepository;
import com.wechat.friends.dao.UserRepository;
import com.wechat.friends.entity.Comment;
import com.wechat.friends.entity.Reply;
import com.wechat.friends.entity.User;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.ReplyState;
import com.wechat.friends.service.RepliesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;


@Service("ReplysService")
public class RepliesServiceImpl implements RepliesService {
	
	@Resource
	ReplyRepository replyRepository;
	
	@Resource
	CommentRepository commentRepository;
	
	@Resource
	UserRepository userRepository;
	
	@Override
	@Transactional
	public Reply createOneReplyByUser (String content, String comment_id,String user_id) throws BusinessException {
		Reply reply=new Reply();
		reply.setReplyState(ReplyState.EXIST);
		reply.setReplyContent(content);
		replyRepository.saveAndFlush(reply);
		
		Optional<Comment> comment=commentRepository.findById(comment_id);
		if(!comment.isPresent()){
			throw new BusinessException("comment is not existed",0,404);
		}
		reply.setComment(comment.get());
		
		Optional<User> user=userRepository.findById(user_id);
		if(!user.isPresent()){
			throw new BusinessException("user is not existed",0,404);
		}
		reply.setUser(user.get());
		return reply;
	}
	
	@Override
	public Reply getOneReply (String id, ReplyState replyState) throws BusinessException {
		Optional<Reply> reply=replyRepository.findByIdAndReplyState(id,replyState);
		if(!reply.isPresent()){
			throw new BusinessException("reply is not existed",0,404);
		}
		return reply.get();
	}
	
	@Override
	public Page<Reply> getAllReplys (ReplyState replyState, String comment_id, int pageSize, int pageNum) throws BusinessException {
		Page<Reply> result=replyRepository.findAllByReplyStateAndComment_Id(replyState,comment_id, PageRequest.of(pageNum,pageSize) );
		return result;
	}
	
	@Override
	@Transactional
	public void deleteOneReply (String id) throws BusinessException {
		Optional<Reply> reply=replyRepository.findById(id);
		if(!reply.isPresent()){
			throw new BusinessException("reply is not existed",0,404);
		}
		reply.get().setReplyState(ReplyState.DELETED);
	}
}
