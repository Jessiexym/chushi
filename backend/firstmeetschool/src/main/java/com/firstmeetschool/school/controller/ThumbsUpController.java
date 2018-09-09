package com.firstmeetschool.school.controller;


import com.firstmeetschool.school.entity.Result;
import com.firstmeetschool.school.entity.ThumbsUp;
import com.firstmeetschool.school.service.ThumbsUpService;
import com.firstmeetschool.school.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThumbsUpController {

    @Autowired
    private ThumbsUpService thumbsUpService;

    @RequestMapping(value = "/thumbsup",method = RequestMethod.POST)
    public Result thumbsUp(@RequestBody ThumbsUp thumbsUp){

        return thumbsUpService.saveThumbsRecord(thumbsUp);
    }


    @RequestMapping(value="/mythumbsup",method = RequestMethod.GET)
    public Result myThumbsUp(int id){
        Result result=thumbsUpService.searchThumbsObject(id);
        return result;
    }

}
