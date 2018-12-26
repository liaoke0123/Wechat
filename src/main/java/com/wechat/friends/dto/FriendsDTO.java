package com.wechat.friends.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

public class FriendsDTO {

    //TODO

    @ApiModelProperty(value="id",required=true)
    @NotBlank
    private String id;

    @ApiModelProperty(value="title",required=false)
    @NotBlank
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
