package com.wechat.friends.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by share on 2019/1/8.
 */
@Entity
@Table(name="wechat_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {
    @Id
//    @GeneratedValue(generator = "jpa-uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50)
    private int id;
    @Column(name="name",nullable = true,length = 50)
    private String name;
    @Column(name="password",nullable = true,length = 50)
    private String password;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}