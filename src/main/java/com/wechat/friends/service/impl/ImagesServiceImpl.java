package com.wechat.friends.service.impl;

import com.wechat.friends.dao.ImageRepository;
import com.wechat.friends.entity.Friend;
import com.wechat.friends.entity.Image;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.service.ImagesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service("ImagesService")
public class ImagesServiceImpl implements ImagesService {

    @Resource
    ImageRepository imageRepository;

    @Value("${filePath}")
    String filePath;


    @Override
    public String fileToPath(MultipartFile file) throws BusinessException {
        if (file.isEmpty()) {
            throw new BusinessException("file is null",0,400);
        }
        String fileName = file.getOriginalFilename();
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        String path = filePath +fileName;
        File dest = new File(path);
        if (dest.exists()) {
            throw new BusinessException("file is existed",0,400);
        }
        if ( !dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new BusinessException("error in uploading",0,500);
        }
        return fileName;
    }

    @Override
    public Image createImage(String path) {
        return createImage(path,false);
    }

    @Override
    public Image createImage(String path, Boolean isZoom) {
        return createImage(path,isZoom,false);
    }

    @Override
    public Image createImage(String path, Boolean isZoom, Boolean isBase64) {
        return createImage(path,isZoom, UUID.randomUUID().toString(),isBase64);
    }

    @Override
    @Transactional
    public Image createImage(String path, Boolean isZoom, String nickname, Boolean isBase64) {
        Image image = new Image();
        image.setNickname(nickname);
        image.setPhysicalAddress(path);
        if (isZoom) {
            image.setMiniImageId(zoomImage(path));
        }else{
            image.setMiniImageId(path);
        }
        if (isBase64) {
            image.setBase64(base64Image(path));
        }
        Image db = imageRepository.saveAndFlush(image);
        return db;
    }

    @Override
    public Image getImage(String id) throws BusinessException {
        Optional<Image> imageO = imageRepository.findById(id);
        if(!imageO.isPresent()){
            throw new BusinessException("file is not existed",0,404);
        }
        return imageO.get();
    }
    
    @Override
    public void deleteImage (String id) throws BusinessException {
        Optional<Image> imageD = imageRepository.findById(id);
		if(!imageD.isPresent()){
			throw new BusinessException("file is not existed",0,404);
		}
		String imageName=imageD.get().getPhysicalAddress();
		String delPath = filePath+imageName;
		File delDest = new File(delPath);
		if (!delDest.exists()) {
			throw new BusinessException("file is not existed",0,404);
		}
	
		delDest.delete();
		imageRepository.deleteById(id);
    }
    
    @Override
    public Image refreshImgFriend (String id,Friend friend) throws BusinessException {
        Optional<Image> img=imageRepository.findById(id);
        if(!img.isPresent()){
            throw new BusinessException("file is not existed",0,404);
        }
        img.get().setFriend(friend);
        return imageRepository.saveAndFlush(img.get());
    }
    
    //***************************private***************************//


    /**
     * 保存一个缩略图
     * @param path
     * @return 缩略图的id 或者 路径
     */
    private String zoomImage(String path) {
        //TODO
        return "0";
    }

    /**
     * 保存一个图片的base64
     * @param path
     * @return
     */
    private String base64Image(String path) {
        //TODO
        return "0";
    }


}
