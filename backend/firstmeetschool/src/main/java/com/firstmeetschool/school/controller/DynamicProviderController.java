package com.firstmeetschool.school.controller;

import com.firstmeetschool.school.entity.Result;
import com.firstmeetschool.school.entity.User;
import com.firstmeetschool.school.service.DynamicProviderService;
import com.firstmeetschool.school.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DynamicProviderController {

    @Autowired(required = false)
    DynamicProviderService dynamicProviderService;

    @RequestMapping(value = "/dyn/findbyid",produces = "application/json")
    public Result getTestUsrById(String usrId){

        User res =  dynamicProviderService.findUserById(usrId);
        return ResultUtils.success(200,res);
    }

    @RequestMapping(value = "/dyn/checkVerify", method = RequestMethod.GET)
    public Result chechVerifyById(String usrId){
        String res =  dynamicProviderService.findIsVerifiedByUsrId(usrId);
        return ResultUtils.success(200,res);
    }

    @RequestMapping(value = "/dyn/getcardnum", method = RequestMethod.GET)
    public Result getInvitationCardsNum(String usrId){
        Integer res = dynamicProviderService.getInvitationCardsNumByUsrId(usrId);
        return ResultUtils.success(200, res);
    }


    @RequestMapping(value = "/dyn/findbyname", method = RequestMethod.GET)
    public Result<List<User>> getTestSameUsrByName(String usrName){
        System.out.println(usrName);
        return ResultUtils.success(200,dynamicProviderService.findUserByNameSql(usrName));
    }


    @RequestMapping(value = "/dyn/homepage", method = RequestMethod.GET)
    public Result<List<User>> getTestUsrInHomepage(String usrSex, Integer lowAge, Integer highAge,
                                                   String isStudent, String usrEducation){
        User user1 = new User();
        user1.setUsrSex(usrSex);
        user1.setIsStudent(isStudent);
        user1.setUsrEducation(usrEducation);
        List<User> results = dynamicProviderService.findUserInHomePage(user1, lowAge, highAge);
        return ResultUtils.success(200,results);
    }


    //TODO: get usrId first

    @RequestMapping(value = "/dyn/update", method = RequestMethod.POST)
    public Result updateUserInfo(User user){
        System.out.println(user);
        return ResultUtils.success(200,dynamicProviderService.dynUpdateUser(user));
    }


    @RequestMapping(value = "/dyn/insert", method = RequestMethod.POST)
    public Result insertOneUser(User user){
        if(dynamicProviderService.insertNewUser(user) == 1){
            return ResultUtils.success(200,"1");
        }else{
            return  ResultUtils.success(200,"0");
        }
    }
}
