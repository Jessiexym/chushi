package com.firstmeetschool.school.service;

import com.firstmeetschool.school.mapper.SelectMapper;
import com.firstmeetschool.school.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectService {

    @Autowired(required = false)
    private SelectMapper selectMapper;

    public User getUserById(String usrId){
        User user = this.selectMapper.findUserById(usrId);
        return user;
    }

    public User getUserByopenid(String openid){
        User user = this.selectMapper.findUserByopenid(openid);
        return user;
    }

    public List<User> getAllUsersInfo(){
        List<User> users = this.selectMapper.findAllUsersList();
        return users;
    }

    public List<User> getUsersByName(String usrName){
        List<User> users = this.selectMapper.findUserByName(usrName);
        return users;
    }

    public List<User> getFilterHomePage(){
        List<User> filterUsers = this.selectMapper.filterHomePage("female", "本科", "yes");
        return filterUsers;
    }
}
