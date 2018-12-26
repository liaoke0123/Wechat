package com.wechat.friends.web;

import com.wechat.friends.entity.Image;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.service.ImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("images")
@Api(description = "图片")
public class ImageController {



    @Resource
    ImagesService imagesService;

    @ApiOperation(value = "上传图片")
    @PostMapping(value = "/uploadFile", produces = "application/json;charset=UTF-8")
    public Object uploadFile(@RequestParam("file") MultipartFile file) throws BusinessException {
        String path=imagesService.fileToPath(file);
        HashMap<String,String> map =  new HashMap<>();
        Image dbImage = imagesService.createImage(path);
        map.put("imageId", dbImage.getId());
        map.put("imagePath", dbImage.getPhysicalAddress());
        return map;
    }

    @ApiOperation(value = "通过id获取图片访问地址")
    @GetMapping("{id}")
    public Object getFileByID(@PathVariable String id) throws BusinessException {
        String path=imagesService.getImage(id).getPhysicalAddress();
        HashMap<String,String> map =  new HashMap<>();
        map.put("path", path);
        return map;
    }

}
