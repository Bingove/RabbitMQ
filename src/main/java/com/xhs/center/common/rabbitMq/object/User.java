package com.xhs.center.common.rabbitMq.object;

import java.io.Serializable;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/28 0028下午 16:08
 * @title: User
 * @ToDo
 */
public class User implements Serializable{
    private String userName;
    private String pwd;
    private String address;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public User(String userName, String pwd, String address) {
        this.userName = userName;
        this.pwd = pwd;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
