package com.wisdom08.service;

import com.wisdom08.NanumarketApplication;
import com.wisdom08.NanumarketException;
import com.wisdom08.dao.IUserDao;
import com.wisdom08.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    IUserDao userDao;

    /**
     *  id(email) 로그인 시도
     * @param id id 또는 이메일
     * @param password
     * @return
     */
    public User login(String id, String password) {

        //aDao.(ddd)
        //bDao.dele()
        //cDao.update()...
        ///
        //TODO ID나 EMAIL로 로그인 되어야 함
        User user = userDao.login(id, password);
        if (user != null) {

        }
        return user;
    }

 /*   public User join(String id, String email, String pw) {
        User user = userDao.join(id, email, pw);
        if (user != null) {

        }
        return user;
    }*/

    public User findUserByEmail(String value) {
        return userDao.findByEmail(value);
    }

    public User FindUserById(String id) {
        return userDao.findById(id);
    }

    @Transactional
    public void join(User user) {
        //TODO 아이디 중복 검사(DAO.FINDBY 이용) => NULL이 와야한다.
        //TODO 이메일 중복 검사(DAO.FINDBY 이용) => NULL이 와야한다.
        
        validateDuplicateUser(user);
        
        
        
        //TODO 이메일 형식 확인
        
        //TODO 패스워드 길이(6글자 이상)
        if (user.getPassword().length() < 4) {
            throw new NanumarketException(409, "SHORT_PW");
        }
        

        userDao.join(user);
    }

    private void validateDuplicateUser(User user) {
        User dupByEmail = userDao.findByEmail(user.getEmail());
        User dupById = userDao.findById(user.getId());
        
        if (!(dupByEmail == null)) {
            throw new IllegalStateException("이미 존재하는 이메일주소");
        }

        if (!(dupById == null)) {
             // throw new IllegalStateException("이미 존재하는 아이디");
            throw new NanumarketException(409, "EXISING_ID");
        }
    }


}
