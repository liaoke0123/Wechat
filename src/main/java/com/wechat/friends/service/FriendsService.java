package com.wechat.friends.service;

import com.wechat.friends.entity.Friend;
import com.wechat.friends.exception.BusinessException;

import java.util.List;

public interface FriendsService {

   Friend createOneMoment(String content,List<String> ids) throws BusinessException;
    
}
