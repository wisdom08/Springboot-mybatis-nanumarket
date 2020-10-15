package com.wisdom08.dto.storage;

import com.wisdom08.dto.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class RemoteUpfile implements IUpfile {

    Long seq;
    String generatedFileName;
    Long ownerSeq;
    private final MultipartFile target;
    private Product product;

    public RemoteUpfile(MultipartFile remoteFile) {
        this.target = remoteFile;
    }

    @Override
    public Long getSeq() {
        return seq;
    }

    @Override
    public String getOriginFileName() {
        return target.getOriginalFilename();
    }

    @Override
    public String getGeneratedFileName() {
        return generatedFileName;
    }

    @Override
    public void setGeneratedFileName(String genFileName) {
        this.generatedFileName = genFileName;
    }

    @Override
    public Integer getFileSize() {
        return (int)target.getSize();
    }

    @Override
    public String getContentType() {
        return target.getContentType();
    }

    @Override
    public Long getOwner() {
        return ownerSeq;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public byte[] getData() throws IOException {
        return target.getBytes();
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public void setOwnerSeq(Long ownerSeq) {
        this.ownerSeq = ownerSeq;
    }
}
