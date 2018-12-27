package com.wechat.friends.entity;

import com.wechat.friends.fenum.FriendsContentType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="wechat_friend")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@EntityListeners(AuditingEntityListener.class) //JPA自动生成时间等字段
public class Friend {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;

    @CreatedDate //创建时间
    @Column(updatable = false) // 默认不修改此数据
    private Date createdDate;

    @LastModifiedDate //最后修改时间
    private Date LastModifiedDate;

    @Column(name="title",nullable = true,length = 50)
    private String title;

    @Column(name="contentType",nullable = false,length = 30)
    private FriendsContentType contentType;

    @Column(name="textContent",nullable = true,columnDefinition = "text",length = 2000)
    private String textContent;

    /**
     * https://www.jianshu.com/p/e8caafce5445
     */
    @OneToMany(mappedBy="friend",cascade=CascadeType.ALL) //PERSIST 创建朋友圈的时
    private Set<Image> images;


    //TODO 评论 点赞


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
        LastModifiedDate = lastModifiedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FriendsContentType getContentType() {
        return contentType;
    }

    public void setContentType(FriendsContentType contentType) {
        this.contentType = contentType;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }


}
