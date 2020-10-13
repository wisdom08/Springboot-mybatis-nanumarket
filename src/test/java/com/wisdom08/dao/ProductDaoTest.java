package com.wisdom08.dao;

import com.wisdom08.dto.Product;
import com.wisdom08.dto.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.thymeleaf.templateresolver.ITemplateResolver;

import javax.lang.model.SourceVersion;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({
        ProductDao.class
})
class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Test
    @Rollback(value = false)
    void insertProduct() {
        Product product = new Product();
        product.setTitle("test title2");
        product.setContent("test content2");
        product.setFiles(null);

        User user = new User(52L, null, null, null);

        product.setSeller(user);


        assertNull(product.getSeq());
        productDao.insertProduct(product);
        assertNotNull(product.getSeq());



    }

}