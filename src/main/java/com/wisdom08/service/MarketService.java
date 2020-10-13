package com.wisdom08.service;

import com.wisdom08.dao.ProductDao;
import com.wisdom08.dao.UpfileDao;
import com.wisdom08.dao.UserDao;
import com.wisdom08.dto.Product;
import com.wisdom08.dto.User;
import com.wisdom08.dto.storage.IUpfile;
import com.wisdom08.service.storage.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarketService {

    @Autowired
    IKeyGenerator keyGen;

    @Autowired
    UserDao userDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    UpfileDao upfileDao;

    @Autowired
    IStorageService storageService;

    /**
     * 판매글 작성함
     * @param sellserSeq
     * @param title
     * @param content
     * @param files
     */
    @Transactional
    public void insertProduct(Long sellserSeq, String title, String content, List<IUpfile> files) {
        // 1. 업로드 파일 체크
        // 1.1. 전체 사이즈 확인
        // 1.2. 한건당 사이즈 확인
        // 2. XSS 필터 추가
        // 3. title, content 길이, 빈 문자열

        User seller = userDao.findBySeq(sellserSeq);
        Product p = new Product();
        p.setTitle(title);
        p.setContent(content);
        p.setFiles(files);
        p.setSeller(seller);

        // 1. db insert
        productDao.insertProduct(p);
        System.out.println("done product " + p.getSeq());

        for (IUpfile file : files) {
            file.setGeneratedFileName(keyGen.getKey());
            file.setProduct(p);
            upfileDao.insertFile(file);
            System.out.println("done upfile");
        }
        for (IUpfile file : files) {
            storageService.upload(file);
        }

    }
}
