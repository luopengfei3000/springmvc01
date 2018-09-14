package com.luopf.service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/14 9:49
 * @Version 1.0
 **/

import com.luopf.dao.IUserDAO;
import com.luopf.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**用户业务*/
@Service
public class UserService {

    @Autowired
    IUserDAO userdao;

    public List<User> queryAllUsers(){
        return userdao.getAll();
    }

    public User getUserById(int id){
        return userdao.getUserById(id);
    }

    public boolean deleteUser(int id){
        return userdao.delete(id);
    }

    public  boolean addUser(User user){
        return userdao.add(user);
    }

    public boolean editUser(User user){
        return userdao.update(user);
    }
}
