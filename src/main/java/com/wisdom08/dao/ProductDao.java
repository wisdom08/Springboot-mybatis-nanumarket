package com.wisdom08.dao;

import com.wisdom08.dto.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

    @Autowired
    SqlSession session;

    public void insertProduct(Product product) {
        session.insert("ProductMapper.insertProduct", product);
    }
}
