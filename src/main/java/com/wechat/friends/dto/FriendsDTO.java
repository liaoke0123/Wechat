package com.wechat.friends.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class FriendsDTO {

    //TODO

//    @ApiModelProperty(value="id",required=true)
//    @NotBlank
    private String id;
    
    
    private List<String> ids;

//    @ApiModelProperty(value="content",required=true)
//    @NotBlank
    private String content;
    
    
    public String getId () {
        return id;
    }
    
    public void setId (String id) {
        this.id = id;
    }
    
    public List<String> getIds () {
        return ids;
    }
    
    public void setIds (List<String> ids) {
        this.ids = ids;
    }
    
    public String getContent () {
        return content;
    }
    
    public void setContent (String content) {
        this.content = content;
    }
}
