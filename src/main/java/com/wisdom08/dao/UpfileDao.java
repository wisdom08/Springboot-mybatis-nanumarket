package com.wisdom08.dao;

import com.wisdom08.dto.storage.IUpfile;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UpfileDao {

    @Autowired
    SqlSession session;

    public void insertFile(IUpfile file) {
        session.insert("UpfileMapper.insertFile", file);
    }
}
