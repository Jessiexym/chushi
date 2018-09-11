package com.firstmeetschool.school.service;

import com.firstmeetschool.school.entity.Invitation;

import java.util.List;


public interface InvitationProviderService {
    int getInvitationCardNum(String senderId);
    Invitation getRecordBysenderIdAndReceiverId(String senderId, String receiverId);
    Invitation getSenderAndReceiverState(String senderId, String receiverId);
    String getReceiverWechatByState(String senderId, String receiverId);
    List<String> getAllSendersbySenderId(String senderId);
    List<String> getAllReceiversbySenderId(String senderId);
    int createInvitationRecord(Invitation invitation);
    int updateInvitationRecord(Invitation invitation);
}
