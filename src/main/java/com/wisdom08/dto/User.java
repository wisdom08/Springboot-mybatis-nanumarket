package com.wisdom08.dto;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

public class User {
    private Long seq;
    private String id;
    private String email;
    private String password;
    private LocalDateTime createdDate;

    public User() {
    }

    //insert 용
    public User(String id, String email, String password) {
       /* this.id = id;
        this.email = email;
        this.password = password;*/

        this(null, id, email, password);
    }

    //select 용
    public User(Long seq, String id, String email, String password) {
        this.seq = seq;
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdDate = LocalDateTime.now();
    }




    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "seq=" + seq +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
