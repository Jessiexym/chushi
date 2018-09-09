package com.firstmeetschool.school.service.Impl;

import com.firstmeetschool.school.entity.Invitation;
import com.firstmeetschool.school.mapper.InvitationProviderMapper;
import com.firstmeetschool.school.service.InvitationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationProviderServiceImpl implements InvitationProviderService {
    @Autowired(required = false)
    InvitationProviderMapper invitationProviderMapper;

    @Override
    public List<String> getAllReceiversbySenderId(String senderId){
        return invitationProviderMapper.getAllReceiversbySenderId(senderId);
    }

    @Override
    public String getReceiverWechatByState(Invitation invitation){
        return invitationProviderMapper.getReceiverWechatByState(invitation);
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
