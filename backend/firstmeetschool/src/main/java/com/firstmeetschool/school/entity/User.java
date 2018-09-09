package com.firstmeetschool.school.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "唯一标识openid")
    private String usrId="";

    @NotBlank(message = "请输入微信号")
    private String usrWechat="";

    @NotBlank(message = "请输入姓名")
    private String usrName="";

    @NotBlank(message = "请输入手机号")
    private String usrTelephone;

    @NotNull(message = "请输入身高" )
    private Integer usrHeight=0;

    @Min(value = 18,message = "未成年")
    private Integer usrAge=18;

    @NotNull(message = "请输入家乡" )
    private String homeTown="";

    @NotNull(message = "请输入所在城市" )
    private String currentCity="";

    @NotNull
    private String usrSex="";

    @NotNull
    private String usrEducation="";

    @NotNull
    private String isStudent="";

    private String atUniversity="";

    private String gradUniversity="";

    private String usrHobby="";

    private String birthDay="";

    private String usrMotto="";

    private String selfIntro="";

    private String usrPicture="";

    private String loverExpect="";

    private String sayWords="";

    // 邀请卡
    private Integer invitationCards=0;

    // 好友邀约
    private Integer calloutNum=0;

    // 点赞数
    private Integer thumbsUp=0;

    // 是否认证
    private String isVerified="";

    // 初识Ta列表
    private String chushiTa="";

    // 身份认证
    private  String identifyPhoto="";



    public void  setId(Integer id){this.id = id;}

<<<<<<< HEAD
    public Integer getId(){return id;}
=======
    private String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
>>>>>>> 81593878418a8d5d0a445a0def8b6899163adef0

    public void setUsrId(String usrId){ this.usrId = usrId;}

    public String getUsrId() {return usrId;}

    public void setUsrName(String usrName) { this.usrName = usrName; }

    public String getUsrName() {return usrName; }

    public void setUsrWechat(String usrWechat) {this.usrWechat = usrWechat; }

    public String getUsrWechat(){return usrWechat;}

    public void setUsrTelephone(String usrTelephone) { this.usrTelephone = usrTelephone;}

    public String getUsrTelephone() { return usrTelephone;}

    public void setUsrHeight(Integer usrHeight) { this.usrHeight = usrHeight;}

    public Integer getUsrHeight() { return usrHeight;}

    public void setUsrAge(Integer usrAge) {this.usrAge = usrAge;}

    public Integer getUsrAge(){ return usrAge;}

    public void setHomeTown(String homeTown) {this.homeTown = homeTown;}

    public String getHomeTown() { return homeTown;}

    public void setCurrentCity(String currentCity) {this.currentCity = currentCity;}

    public String getCurrentCity(){ return currentCity;}

    public void setUsrSex(String usrSex) {this.usrSex = usrSex;}

    public String getUsrSex() {return usrSex;}

    public void setUsrEducation(String usrEducation) {this.usrEducation = usrEducation;}

    public String getUsrEducation() {return usrEducation;}

    public void setIsStudent(String isStudent) {this.isStudent = isStudent;}

    public String getIsStudent(){ return isStudent; }

    public void setAtUniversity(String atUniversity) {this.atUniversity = atUniversity;}

    public String getAtUniversity() { return atUniversity;}

    public void setGradUniversity(String gradUniversity) {this.gradUniversity = gradUniversity;}

    public String getGradUniversity() {return gradUniversity;}

    public void setUsrHobby(String usrHobby) {this.usrHobby = usrHobby;}

    public String getUsrHobby() {return usrHobby;}

    public void setBirthDay(String birthDay) {this.birthDay = birthDay;}

    public String getBirthDay() {return birthDay;}

    public void setUsrMotto(String usrMotto) {this.usrMotto = usrMotto;}

    public String getUsrMotto() {return usrMotto;}

    public void setSelfIntro(String selfIntro) { this.selfIntro = selfIntro;}

    public String getSelfIntro() {return selfIntro;}

    public void setUsrPicture(String usrPicture) {this.usrPicture = usrPicture;}

    public String getUsrPicture() {return usrPicture;}

    public void setLoverExpect(String loverExpect) {this.loverExpect = loverExpect;}

    public String getLoverExpect() {return loverExpect;}

    public void setSayWords(String sayWords) {this.sayWords = sayWords;}

    public String getSayWords() {return sayWords;}

    public void setInvitationCards(Integer invitationCards) {this.invitationCards = invitationCards;}

    public Integer getInvitationCards() {return invitationCards;}

    public void setCalloutNum(Integer calloutNum) {this.calloutNum = calloutNum;}

    public Integer getCalloutNum() { return calloutNum; }

    public Integer getThumbsUp() { return thumbsUp; }

    public void setThumbsUp(Integer thumbsUp) {this.thumbsUp=thumbsUp;}

    public String getIsVerified(){ return isVerified;}

    public void setIsVerified (String isVerified) {this.isVerified = isVerified;}

    public String getChushiTa () {return chushiTa;}

    public void setChushiTa (String chushiTa) {this.chushiTa=chushiTa;}

    public String getIdentifyPhoto() {return identifyPhoto;}

    public void setIdentifyPhoto (String identifyPhoto) {this.identifyPhoto=identifyPhoto;}

    @Override
    public String toString(){

        return "User{" +
                "usrId=" + usrId +
                ", usrName='" + usrName + '\'' +
                ", usrWechat='" + usrWechat + '\'' +
                ", usrAge=" + usrAge +
                ", usrSex='" + usrSex + '\'' +
                ", usrHeight=" + usrHeight +
                ", usrMotto='" + usrMotto + '\'' +
                ", usrTelephone='" + usrTelephone + '\'' +
                ", usrEducation='" + usrEducation + '\'' +
                ", usrHobby='" + usrHobby + '\'' +
                ", isStudent='" + isStudent + '\'' +
                ", atUniversity='" + atUniversity + '\'' +
                ", gradUniversity='" + gradUniversity + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", currentCity='" + currentCity + '\'' +
                ", selfIntro='" + selfIntro + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", usrPicture='" + usrPicture + '\'' +
                ", loverExpect='" + loverExpect + '\'' +
                ", sayWords='" + sayWords + '\'' +
                ", invitationCards=" + invitationCards +
                ", calloutNum=" + calloutNum +
                ", thumbsUp=" + thumbsUp  +
                ", isVerified="+ isVerified +
                ", chushiTa="+ chushiTa +
                ", identifyPhoto"+ identifyPhoto +
                '}';
    }

}
