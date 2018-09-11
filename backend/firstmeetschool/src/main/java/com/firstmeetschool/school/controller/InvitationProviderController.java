package com.firstmeetschool.school.controller;

import com.firstmeetschool.school.entity.Invitation;
import com.firstmeetschool.school.service.InvitationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class InvitationProviderController {

    @Autowired(required = false)
    InvitationProviderService invitationProviderService;

    @RequestMapping(value = "/invitation/cardsnum", method = RequestMethod.GET)
    public int getSenderInvitationCards(String senderId){
        return invitationProviderService.getInvitationCardNum(senderId);
    }
    @RequestMapping(value = "/invitation/state", method = RequestMethod.GET)
    public int getSenderReceiverState(String senderId, String receiverId){
        Invitation res = invitationProviderService.getSenderAndReceiverState(senderId, receiverId);
        Integer state = 0;
        try {
            return res.getReceiverState();
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping(value = "/invitation/receiver/wechat", method = RequestMethod.GET)
    public String getReceiverWechatByStates(String senderState, String receiverState, String senderId, String receiverId){
        try {
            return invitationProviderService.getReceiverWechatByState(senderId, receiverId);
        }catch (Exception e){
            return "fail.";
        }
    }

    @RequestMapping(value = "/invitation/senderlist", method = RequestMethod.GET)
    public List<String> getAllSendersbySenderId(String senderId){
        return invitationProviderService.getAllSendersbySenderId(senderId);
    }

    @RequestMapping(value = "/invitation/receiverlist", method = RequestMethod.GET)
    public List<String> getAllReceiversbySenderId(String senderId){
        return invitationProviderService.getAllReceiversbySenderId(senderId);
    }

    @RequestMapping(value = "/invitation/insert", method = RequestMethod.POST)
    public int InsertInvitationRecord(Invitation invitation){
        return invitationProviderService.createInvitationRecord(invitation);
    }

    @RequestMapping(value = "/invitation/update", method = RequestMethod.POST)
    public int UpdateInvitationRecord(Invitation invitation){
        return invitationProviderService.updateInvitationRecord(invitation);
    }

}
