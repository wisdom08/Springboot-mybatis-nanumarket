package com.wisdom08.dto;

import com.wisdom08.dto.storage.IUpfile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public class Product {

    Long seq;
    String title;
    String content;
    List<IUpfile> files;
    User seller;

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<IUpfile> getFiles() {
        return files;
    }

    public void setFiles(List<IUpfile> files) {
        this.files = files;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
