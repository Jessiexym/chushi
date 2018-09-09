package com.firstmeetschool.school.mapper;

import com.firstmeetschool.school.entity.ThumbsUp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ThumbsUpMapper {


    @Insert("INSERT INTO thumbsup(thumbsedid,thumbsid,thumbsTime)"
            +"VALUES(#{thumbsedid},#{thumbsid},#{thumbsTime})")
    int insert(@Param("thumbsedid") int thumbsedid, @Param("thumbsid") int thumbsid,
               @Param("thumbsTime") Long thumbsTime);

    @Select("select * from thumbsup where thumbsedid = #{thumbsedid}")
    List<ThumbsUp> searchWhoToMe(@Param("thumbsedid") int thumbsedid);

    @Select("select * from thumbsup where thumbsid = #{thumbsid}")
    List<ThumbsUp> searchIToWho(@Param("thumbsid") int thumbsid);
}
