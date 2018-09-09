package com.firstmeetschool.school.service;

import com.firstmeetschool.school.entity.User;

import java.util.List;

public interface DynamicProviderService {
    User findUserById(String usrId);
    String findIsVerifiedByUsrId(String id);
    Integer getInvitationCardsNumByUsrId(String id);
    List<User> findUserByNameSql(String usrName);
    List<User> findUserInHomePage(User user, Integer lowAge, Integer highAge);
    int dynUpdateUser(User user);
    int insertNewUser(User user);
}
