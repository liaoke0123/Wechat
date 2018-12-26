package com.wechat.friends.dao;

import com.wechat.friends.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImageRepository extends JpaRepository<Image,String>,JpaSpecificationExecutor<ImageRepository>{


}
