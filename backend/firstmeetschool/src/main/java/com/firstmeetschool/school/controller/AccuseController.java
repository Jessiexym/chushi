package com.firstmeetschool.school.controller;


import com.firstmeetschool.school.entity.Accuse;
import com.firstmeetschool.school.entity.Result;
import com.firstmeetschool.school.service.AccuseService;
import com.firstmeetschool.school.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccuseController {


    @Autowired
    private AccuseService accuseService;


    @RequestMapping(value = "/accusesomeone",method = RequestMethod.POST)
    public Result accuseSomeone(@RequestBody Accuse accuse){

        int result=accuseService.saveAccuseInfo(accuse);
        if(result==1) {
            return ResultUtils.success(200, "举报成功");
        }

        return ResultUtils.success(201, "举报失败");
    }
}
