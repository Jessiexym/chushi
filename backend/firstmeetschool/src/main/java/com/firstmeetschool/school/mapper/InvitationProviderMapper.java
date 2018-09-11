package com.firstmeetschool.school.mapper;

import com.firstmeetschool.school.entity.Invitation;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

@Mapper
public interface InvitationProviderMapper {
    @SelectProvider(type = invitationSqlProvider.class, method = "getInvitaionCardsNum") //查看邀约者邀约卡数
    int getInvitationCardNum(String senderId);

    @SelectProvider(type = invitationSqlProvider.class, method = "getTwoPairState")  //查看邀约者与被邀约者状态
    Invitation getSenderAndReceiverState(Map<String, Object> map);

    @SelectProvider(type = invitationSqlProvider.class, method = "getReceiverWechatByStates") //查找已同意的被邀约者微信
    String getReceiverWechatByState(Map<String, Object> map);

    @SelectProvider(type = invitationSqlProvider.class, method = "getSenderListById") //我邀约了谁List
    List<String> getAllSendersbySenderId(String senderId);

    @SelectProvider(type = invitationSqlProvider.class, method = "getReceiverListById") //谁邀约了我List
    List<String> getAllReceiversbySenderId(String senderId);

    @InsertProvider(type = invitationSqlProvider.class, method = "createInvitationPair") //插入一条邀约记录
    int createInvitationRecord(Invitation invitation);

    @UpdateProvider(type = invitationSqlProvider.class, method = "updateInvitationPairState") //更新邀约者与被邀约者状态
    int updateInvitationRecord(Invitation invitation);

    class invitationSqlProvider{
        public String getInvitaionCardsNum(final String senderId){
            return new SQL(){
                {
                   SELECT("invitationCards");
                   FROM("user");
                   WHERE("usrId="+senderId);
                }
            }.toString();
        }

        public String getTwoPairState(final Map<String, Object> pairMap){
            return new SQL(){
                {
                    SELECT("*");
                    FROM("invitation");
                    if(StringUtils.isNotBlank((String)pairMap.get("senderId"))){
                        WHERE("senderId=#{senderId}");
                    }
                    if(StringUtils.isNotBlank((String)pairMap.get("receiverId"))){
                        WHERE("receiverId=#{receiverId}");
                    }
                }
            }.toString();
        }

        public String getReceiverWechatByStates(final Map<String, Object> pairMap){
            return new SQL(){
                {
                    SELECT("usrWechat");
                    FROM("user,invitation");
//                    if(StringUtils.isNotBlank((String)pairMap.get("senderState")) && ((int)pairMap.get("senderState")==3)){
//                        WHERE("senderState=#{senderState}");
//                    }
//                    if(StringUtils.isNotBlank((String)pairMap.get("receiverState")) && ((int)pairMap.get("receiverState")==3)){
//                        WHERE("receiverState=#{receiverState}");
//                    }
                    if(StringUtils.isNotBlank((String)pairMap.get("senderId"))){
                        WHERE("invitation.senderId=#{senderId}");
                    }
                    if(StringUtils.isNotBlank((String)pairMap.get("receiverId"))){
                        WHERE("invitation.receiverId=#{receiverId}");
                    }
                    WHERE("user.usrId=invitation.receiverId");
                }
            }.toString();
        }

        public String getSenderListById(final String senderId){
            return new SQL(){
                {
                    SELECT("receiverId");
                    FROM("invitation");
                    if(StringUtils.isNotBlank(senderId)) {
                        WHERE("senderId=" + senderId);
                    }
                }
            }.toString();
        }

        public String getReceiverListById(final String senderId){
            return new SQL(){
                {
                    SELECT("senderId");
                    FROM("invitation");
                    if(StringUtils.isNotBlank(senderId)) {
                        WHERE("receiverId=" + senderId);
                    }
                }
            }.toString();
        }


        public String createInvitationPair(Invitation invitation){
            return new SQL(){
                {
                    INSERT_INTO("invitation");
                    if (invitation.getSenderId() != null) {
                        VALUES("senderId", "#{senderId}");
                        VALUES("senderState", "1");
                    }
                    if (invitation.getReceiverId() != null) {
                        VALUES("receiverId", "#{receiverId}");
                        VALUES("receiverState", "1");
                    }
                    if(invitation.getInvitationWords() != null){
                        VALUES("invitationWords", "#{invitationWords}");
                    }
                }
            }.toString();
        }

        public String updateInvitationPairState(Invitation invitation){
            return new SQL(){
                {
                   UPDATE("invitation");
                   if(invitation.getReceiverState()!= null){
                       SET("senderState=#{senderState}");
                       SET("receiverState=#{senderState}");
//                   }else if(invitation.getReceiverState()==3){
//                       SET("senderState=3");
                   }
                }
            }.toString();
        }


    }
}
