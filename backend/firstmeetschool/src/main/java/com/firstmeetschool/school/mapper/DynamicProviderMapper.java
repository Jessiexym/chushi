package com.firstmeetschool.school.mapper;


import com.firstmeetschool.school.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

@Mapper
public interface DynamicProviderMapper {

    @SelectProvider(type = UserDynamicSqlProvider.class, method = "findUserByIdSql")
    User findUserById(String id);

    @SelectProvider(type = UserDynamicSqlProvider.class, method = "findVerifyStateByIdSql")
    String findIsVerifiedByUsrId(String id);

    @SelectProvider(type = UserDynamicSqlProvider.class, method = "findCardNumByIdSql")
    Integer getInvitationCardsNumByUsrId(String id);

    @SelectProvider(type = UserDynamicSqlProvider.class, method = "findUserByNameSql")
    List<User> findUserByNameSql(String usrName);

    @SelectProvider(type = UserDynamicSqlProvider.class, method = "findUserInHomePageSql")
    List<User> findUserInHomePage(Map<String, Object> map);

    @UpdateProvider(type = UserDynamicSqlProvider.class, method = "dynUpdateUser")
    int dynUpdateUser(User user);

    @InsertProvider(type = UserDynamicSqlProvider.class, method = "insertNewUserBySql")
    @Options(useGeneratedKeys = true, keyProperty = "usrId")
    int insertNewUser(User user);

//    List<User> findUserInHomePage(@Param("usrSex") String usrSex, @Param("isStudent") String isStudent,
//                                  @Param("usrEducation") String usrEducation);

    class UserDynamicSqlProvider {

        public String findUserByIdSql(final String userId){
            return new SQL(){
                {
                    SELECT("*");
                    FROM("user");
                    WHERE("usrId="+userId);
                }
            }.toString();
        }

        public String findVerifyStateByIdSql(final String usrId){
            return new SQL(){
                {
                    SELECT("isVerified");
                    FROM("user");
                    WHERE("usrId="+usrId);
                }
            }.toString();
        }

        public String findCardNumByIdSql(final String usrId){
            return new SQL(){
                {
                    SELECT("invitationCards");
                    FROM("user");
                    WHERE("usrId="+usrId);
                }
            }.toString();
        }


        public String findUserByNameSql(final String usrName){
            return new SQL(){
                {
                    SELECT("*");
                    FROM("user");
                    if(StringUtils.isNotBlank(usrName)) {
                        WHERE("usrName=#{usrName}");
                    }
                }
            }.toString();
        }

        public String findUserInHomePageSql(final Map<String, Object> map){
            return new SQL(){
                {
                    SELECT("*");
                    FROM("user");
//                    WHERE("usrAge >= 20 AND usrAge <=27");
                    if(StringUtils.isNotBlank((String)map.get("usrSex"))){
                        WHERE("usrSex=#{usrSex}");
                    }
                    if((map.get("lowAge") != null) && (map.get("highAge") !=null)){
                        WHERE("usrAge >= #{lowAge} AND usrAge <= #{highAge}");
                    }
                    if(StringUtils.isNotBlank((String)map.get("isStudent"))){
                        WHERE("isStudent=#{isStudent}");
                    }
                    if(StringUtils.isNotBlank((String)map.get("usrEducation"))){
                        WHERE("usrEducation=#"+"{usrEducation}");
                    }
                }
            }.toString();

        }

        public String dynUpdateUser(User user) {
            return new SQL() {
                {
                    UPDATE("user");
                    if (user.getUsrName() != null) {
                        SET("usrName = #{usrName}");
                    }
                    if (user.getUsrWechat() != null) {
                        SET("usrWechat = #{usrWechat}");
                    }
                    if (user.getUsrTelephone() != null) {
                        SET("usrTelephone = #{usrTelephone}");
                    }
                    if (user.getUsrHeight() != null) {
                        SET("usrHeight = #{usrHeight}");
                    }
                    if (user.getUsrAge() != null) {
                        SET("usrAge = #{usrAge}");
                    }
                    if (user.getHomeTown() != null) {
                        SET("homeTown = #{homeTown}");
                    }
                    if (user.getCurrentCity() != null) {
                        SET("currentCity = #{currentCity}");
                    }
                    if (user.getUsrSex() != null) {
                        SET("usrSex = #{usrSex}");
                    }
                    if (user.getUsrEducation() != null) {
                        SET("usrEducation = #{usrEducation}");
                    }
                    if (user.getIsStudent() != null) {
                        SET("isStudent = #{isStudent}");
                    }
                    if (user.getAtUniversity() != null) {
                        SET("atUniversity = #{atUniversity}");
                    }
                    if (user.getGradUniversity() != null) {
                        SET("gradUniversity = #{gradUniversity}");
                    }
                    if (user.getUsrHobby() != null) {
                        SET("usrHobby = #{usrHobby}");
                    }
                    if (user.getBirthDay() != null) {
                        SET("birthDay = #{birthDay}");
                    }
                    if (user.getUsrMotto() != null) {
                        SET("usrMotto = #{usrMotto}");
                    }
                    if (user.getSelfIntro() != null) {
                        SET("selfIntro = #{selfIntro}");
                    }
                    if (user.getUsrPicture() != null) {
                        SET("usrPicture = #{usrPicture}");
                    }
                    if (user.getLoverExpect() != null) {
                        SET("loverExpect = #{loverExpect}");
                    }
                    if (user.getSayWords() != null) {
                        SET("sayWords = #{sayWords}");
                    }
                    if (user.getInvitationCards() != null) {
                        SET("invitationCards = #{invitationCards}");
                    }
                    if (user.getCalloutNum() != null) {
                        SET("calloutNum = #{calloutNum}");
                    }
                    if(user.getThumbsUp() != null){
                        SET("likeNum = #{likeNum}");
                    }
                    if(user.getIsVerified() != null){
                        SET("isVerified = #{isVerified}");
                    }
                    if(user.getChushiTa() != null){
                        SET("chushiTa = #{chushiTa}");
                    }
                    if(user.getIdentifyPhoto() != null){
                        SET("identifyPhoto = #{identifyPhoto}");
                    }
                    WHERE("usrId = #{usrId}");
                }
            }.toString();

        }

        public String insertNewUserBySql(final User user){
            return new SQL() {
                {
                    INSERT_INTO("user");
                    if (user.getUsrId() != null) {
                        VALUES("usrId", "#{usrId}");
                    }
                    if (user.getUsrName() != null) {
                        VALUES("usrName", "#{usrName}");
                    }
                    if(user.getUsrWechat()!=null){
                        VALUES("usrWechat", "#{usrWechat}");
                    }
                    if(user.getUsrTelephone() !=null){
                        VALUES("usrTelephone", "#{usrTelephone}");
                    }
                    if(user.getUsrHeight() != null){
                        VALUES("usrHeight", "#{usrHeight}");
                    }
                    if(user.getUsrAge() != null){
                        VALUES("usrAge", "#{usrAge}");
                    }
                    if(user.getHomeTown() != null){
                        VALUES("homeTown", "#{homeTown}");
                    }
                    if(user.getCurrentCity() != null){
                        VALUES("currentCity", "#{currentCity}");
                    }
                    if(user.getUsrSex() != null){
                        VALUES("usrSex", "#{usrSex}");
                    }
                    if(user.getUsrEducation() != null){
                        VALUES("usrEducation", "#{usrEducation}");
                    }
                    if(user.getIsStudent() != null){
                        VALUES("isStudent", "#{isStudent}");
                    }
                    if(user.getAtUniversity() != null){
                        VALUES("atUniversity", "#{atUniversity}");
                    }
                    if(user.getGradUniversity() != null){
                        VALUES("gradUniversity", "#{gradUniversity}");
                    }
                    if(user.getUsrHobby() != null){
                        VALUES("usrHobby", "#{usrHobby}");
                    }if(user.getBirthDay() != null){
                    VALUES("birthDay", "#{birthDay}");
                    }
                    if(user.getUsrMotto() != null){
                        VALUES("usrMotto", "#{usrMotto}");
                    }
                    if(user.getSelfIntro() != null){
                        VALUES("selfIntro", "#{selfIntro}");
                    }
                    if(user.getUsrPicture() != null){
                        VALUES("usrPicture", "#{usrPicture}");
                    }
                    if(user.getLoverExpect() != null){
                        VALUES("loverExpect", "#{loverExpect}");
                    }
                    if(user.getSayWords() != null){
                        VALUES("sayWords", "#{sayWords}");
                    }
                    if(user.getInvitationCards() != null){
                        VALUES("invitationCards", "#{invitationCards}");
                    }
                    if(user.getCalloutNum() != null){
                        VALUES("calloutNum", "#{calloutNum}");
                    }
                    if(user.getThumbsUp() != null){
                        VALUES("likeNum", "#{likeNum}");
                    }
                    if(user.getIsVerified() != null){
                        VALUES("isVerified", "#{isVerified}");
                    }
                    if(user.getChushiTa() != null){
                        VALUES("chushiTa", "#{chushiTa}");
                    }
                    if(user.getIdentifyPhoto() != null){
                        VALUES("identifyPhoto", "#{identifyPhoto}");
                    }

                }
            }.toString();
        }

    }
}
