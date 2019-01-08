package com.wechat.friends.dto;

/**
 * Created by share on 2019/1/8.
 */
public class SortDTO {
    //排序方式
    private String orderType;

    //排序字段
    private String orderField;

    //构造函数，指定排序字段，默认升序排列
    public SortDTO(){
        this.orderField = "id";
        this.orderType = "desc";
    }
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }
}
