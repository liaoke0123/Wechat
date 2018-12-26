package com.wechat.friends.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="wechat_images")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@EntityListeners(AuditingEntityListener.class) //JPA自动生成时间等字段
public class Image {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;

    @CreatedDate //创建时间
    @Column(updatable = false) // 默认不修改此数据
    private Date createdDate;

    @LastModifiedDate //最后修改时间
    private Date LastModifiedDate;

    @Column(name="nickname",nullable = true,length = 50)
    private String nickname;// 别名

    @Column(name="miniImageId",nullable = false,length = 128)
    private String miniImageId; //缩略图id 或者路径

    @Column(name="physicalAddress",nullable = false,columnDefinition = "text")
    private String physicalAddress; //真实物理地址

    @Column(name="base64",nullable = true,columnDefinition = "text") //大文本
    private String base64; //提供的base64的编码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.LastModifiedDate = lastModifiedDate;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMiniImageId() {
        return miniImageId;
    }

    public void setMiniImageId(String miniImageId) {
        this.miniImageId = miniImageId;
    }
}
