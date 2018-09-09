package com.firstmeetschool.school.service;

import com.firstmeetschool.school.entity.Accuse;
import com.firstmeetschool.school.mapper.AccuseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccuseService {

    @Autowired(required = false)
    private AccuseMapper accuseMapper;

    public int saveAccuseInfo(Accuse accuse){
       int a= accuseMapper.insert(accuse.getId(),accuse.getType()
                ,accuse.getContent(),accuse.getReporterId());
       return a;

    }
}
