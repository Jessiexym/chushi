package com.firstmeetschool.school.controller;


import com.firstmeetschool.school.entity.User;
import com.firstmeetschool.school.service.SelectService;
import com.firstmeetschool.school.utils.CollectUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * @function: select user from DB.
 * @author:xym
 * @ 15th, July, 2018
 */

@RestController
public class SelectController {

    @Autowired
    private SelectService userService;

//    @RequestMapping(value = "/id", method = RequestMethod.GET)
////    public String getUserById() {
////        User user = userService.getUserById();
////        return user.getUsrName();
////    }

    @RequestMapping(value = "/{usrId}", method = RequestMethod.GET)
    public User getNewUserById(@PathVariable("usrId") String usrId){
        User res =  userService.getUserById(usrId);
        return res;
    }


    @RequestMapping(value = "/same/{usrName}", method = RequestMethod.GET)
    public String getUserByName(@PathVariable("usrName") String usrName) {
        List<User> users = userService.getUsersByName(usrName);
        CollectUserInfo tempUser = new CollectUserInfo();
        tempUser.setUserList(users);
        String res = tempUser.collectUserListInfo(users);
        return res;
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllusers() {
        List<User> users = userService.getAllUsersInfo();
        CollectUserInfo allUsers = new CollectUserInfo();
        allUsers.setUserList(users);
        String res = allUsers.collectUserListInfo(users);
        return res;
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String getHomePage(){
        List<User> filterUsers = userService.getFilterHomePage();
        CollectUserInfo homePageUsers = new CollectUserInfo();
        homePageUsers.setUserList(filterUsers);
        String res = homePageUsers.collectUserListInfo(filterUsers);
        return res;
    }

}


