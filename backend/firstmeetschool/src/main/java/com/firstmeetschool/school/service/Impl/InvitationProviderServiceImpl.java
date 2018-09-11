package com.firstmeetschool.school.service.Impl;

import com.firstmeetschool.school.entity.Invitation;
import com.firstmeetschool.school.mapper.InvitationProviderMapper;
import com.firstmeetschool.school.service.InvitationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvitationProviderServiceImpl implements InvitationProviderService {
    @Autowired(required = false)
    InvitationProviderMapper invitationProviderMapper;

    @Override
    public int getInvitationCardNum(String senderId){
        return invitationProviderMapper.getInvitationCardNum(senderId);
    }

    @Override
    public Invitation getSenderAndReceiverState(String senderId, String receiverId){
        Map<String, Object> pairMap = new HashMap<>();
        pairMap.put("senderId", senderId);
        pairMap.put("receiverId", receiverId);
        return invitationProviderMapper.getSenderAndReceiverState(pairMap);
    }

    @Override
    public String getReceiverWechatByState(String senderId, String receiverId){
        Map<String, Object> pairMap = new HashMap<>();
//        pairMap.put("senderState", senderState);
//        pairMap.put("receiverState", receiverState);
        pairMap.put("senderId", senderId);
        pairMap.put("receiverId", receiverId);
        return invitationProviderMapper.getReceiverWechatByState(pairMap);
    }

    @Override
    public List<String> getAllSendersbySenderId(String senderId){
        return invitationProviderMapper.getAllSendersbySenderId(senderId);
    }

    @Override
    public List<String> getAllReceiversbySenderId(String senderId){
        return invitationProviderMapper.getAllReceiversbySenderId(senderId);
    }

    @Override
    public int createInvitationRecord(Invitation invitation){
        return invitationProviderMapper.createInvitationRecord(invitation);
    }

    @Override
    public int updateInvitationRecord(Invitation invitation){
        return invitationProviderMapper.updateInvitationRecord(invitation);
    }

}
