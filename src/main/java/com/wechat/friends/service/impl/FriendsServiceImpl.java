package com.wechat.friends.service.impl;


import com.wechat.friends.dao.FriendRepository;
import com.wechat.friends.dao.ImageRepository;
import com.wechat.friends.entity.Friend;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.FriendsContentType;
import com.wechat.friends.service.FriendsService;
import com.wechat.friends.service.ImagesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("FriendsService")
public class FriendsServiceImpl implements FriendsService {
	
	@Resource
	FriendRepository friendRepository;
	
	@Resource
	ImageRepository imageRepository;
	
	@Resource
	ImagesService imagesService;
	
	@Override
	@Transactional
	public Friend createOneMoment (String content,List<String> ids) throws BusinessException {
		//create friend in db
		Friend friend=new Friend();
		friend.setTextContent(content);
		friend.setContentType(FriendsContentType.NORMAL);
		Friend friendIndb = friendRepository.saveAndFlush(friend);
		//refresh img in db
		for(String id:ids){
			imagesService.refreshImgFriend(id,friendIndb);
		}
		
		return friend;
	}
	
}
