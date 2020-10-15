package com.wisdom08.dto.storage;

import com.wisdom08.dto.Product;

import java.io.IOException;

public interface IUpfile {

    Long getSeq();
    String getOriginFileName();
    String getGeneratedFileName();
    void setGeneratedFileName(String genFileName);
    Integer getFileSize();
    String getContentType();
    Long getOwner();


    Product getProduct();
    void setProduct(Product product);

    byte[] getData() throws IOException;
}
