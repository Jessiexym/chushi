package com.firstmeetschool.school.mapper;

import com.firstmeetschool.school.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface SelectMapper {

    @Select("select * from user")
    List<User> findAllUsersList();

    @Select("select * from user where usrId = #{usrId}")
    User findUserById(@Param("usrId") String usrId);

    @Select("select * from user where openid = #{openid}")
    User findUserByopenid(@Param("openid") String openid);

    @Select("SELECT * FROM user WHERE usrName = #{usrName}")
    List<User> findUserByName(@Param("usrName") String usrName);

    @Select("SELECT * FROM user WHERE usrSex = #{usrSex} AND usrEducation = #{usrEducation} AND isStudent = #{isStudent}")
    List<User> filterHomePage(@Param("usrSex") String usrSex, @Param("usrEducation") String usrEducation,
                              @Param("isStudent") String isStudent);



}
