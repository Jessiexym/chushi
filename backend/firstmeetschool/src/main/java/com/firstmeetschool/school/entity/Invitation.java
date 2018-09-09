package com.firstmeetschool.school.entity;

//import javax.persistence.Entity;
//
//@Entity
public class Invitation {
    private Integer id;
    private String senderId;
    private String receiverId;
    private Integer senderState;
    private Integer receiverState;

    public Integer getId() { return id; }

    public void setId(Integer id){ this.id = id;}

    public String getSenderId() {return senderId;}

    public void setSenderId(String senderId){ this.senderId=senderId;}

    public String getReceiverId() {return receiverId;}

    public void setReceiverId(String receiverId) {this.receiverId=receiverId;}

    public Integer getSenderState() {return senderState;}

    public void setSenderState(Integer senderState) {this.senderState=senderState;}

    public Integer getReceiverState() {return receiverState;}

    public void setReceiverState(Integer receiverState) {this.senderState=receiverState;}
}
