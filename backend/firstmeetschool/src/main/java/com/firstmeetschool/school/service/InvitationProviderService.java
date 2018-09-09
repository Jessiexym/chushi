package com.firstmeetschool.school.service;

import com.firstmeetschool.school.entity.Invitation;

import java.util.List;

public interface InvitationProviderService {
    List<String> getAllReceiversbySenderId(String senderId);
    String getReceiverWechatByState(Invitation invitation);
    int createInvitationRecord(Invitation invitation);
    int updateInvitationRecord(Invitation invitation);
}
