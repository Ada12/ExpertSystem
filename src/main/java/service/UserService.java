package service;

import dao.UserDao;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangchen on 17/7/1.
 */

@Transactional
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserEntity getUser(String username) {
        return userDao.getUser(username);
    }
}
