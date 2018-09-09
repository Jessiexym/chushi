package com.firstmeetschool.school.mapper;

import com.firstmeetschool.school.entity.Invitation;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface InvitationProviderMapper {
    @SelectProvider(type = invitationSqlProvider.class, method = "getReceiverListById")
    List<String> getAllReceiversbySenderId(String senderId);

    @SelectProvider(type = invitationSqlProvider.class, method = "getReceiverWechatByState")
    String getReceiverWechatByState(Invitation invitation);

    @InsertProvider(type = invitationSqlProvider.class, method = "createInvitationPair")
    int createInvitationRecord(Invitation invitation);

    @UpdateProvider(type = invitationSqlProvider.class, method = "updateInvitationPairState")
    int updateInvitationRecord(Invitation invitation);

    class invitationSqlProvider{
        public String getReceiverListById(final String senderId){
            return new SQL(){
                {
                    SELECT("receiverId");
                    FROM("Invitation");
                    WHERE("senderId="+senderId);
                }
            }.toString();

        }

        public String getReceiverWechatByState(Invitation invitation){
            return new SQL(){
                {
                    SELECT("usrWechat");
                    FROM("user");
                    if(invitation.getReceiverState()==6){
                        WHERE("usrId="+invitation.getReceiverId());
                    }
                }
            }.toString();
        }

        public String createInvitationPair(Invitation invitation){
            return new SQL(){
                {
                    INSERT_INTO("Invitation");
                    if (invitation.getSenderId() != null) {
                        VALUES("senderId", "#{senderId}");
                        VALUES("senderState", "1");
                    }
                    if (invitation.getReceiverId() != null) {
                        VALUES("receiverId", "#{receiverId}");
                        VALUES("receiverState", "3");
                    }
                }
            }.toString();
        }

        public String updateInvitationPairState(Invitation invitation){
            return new SQL(){
                {
                   UPDATE("invitation");
                   if(invitation.getReceiverState()==5){
                       SET("senderState=2");
                   }else if(invitation.getReceiverState()==6){
                       SET("senderState=3");
                   }
                }
            }.toString();
        }


    }
}
