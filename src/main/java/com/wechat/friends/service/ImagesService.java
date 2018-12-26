package com.wechat.friends.service;

import com.wechat.friends.entity.Image;
import com.wechat.friends.exception.BusinessException;
import org.springframework.web.multipart.MultipartFile;

public interface ImagesService {

    String fileToPath(MultipartFile file) throws BusinessException; //返回path

    Image createImage(String path); //默认isZoom 是false ,nickname是随机值, 无需base64编码

    Image createImage(String path,Boolean isZoom);  //默认nickname是随机值，无需base64编码

    Image createImage(String path,Boolean isZoom,Boolean isBase64); //默认nickname是随机值

    Image createImage(String path, Boolean isZoom, String nickname, Boolean isBase64);

    Image getImage(String id) throws BusinessException;

}
