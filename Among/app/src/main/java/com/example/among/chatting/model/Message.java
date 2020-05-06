package com.example.among.chatting.model;

import java.util.Date;
import java.util.List;

public class Message {
    //메시지에 대한 공통 속성
    private String messageId;
    private UserChat messageUserChat;
    private String chatId;
    private int unreadCount;
    private Date messageDate;
    private MessageType messageType;
    private List<String> readUserList;


    public enum MessageType{
        TEXT,PHOTO,EXIT
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public UserChat getMessageUserChat() {
        return messageUserChat;
    }

    public void setMessageUserChat(UserChat messageUserChat) {
        this.messageUserChat = messageUserChat;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public List<String> getReadUserList() {
        return readUserList;
    }

    public void setReadUserList(List<String> readUserList) {
        this.readUserList = readUserList;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", messageUser=" + messageUserChat +
                ", chatId='" + chatId + '\'' +
                ", unreadCount=" + unreadCount +
                ", messageDate=" + messageDate +
                ", messageType=" + messageType +
                ", readUserList=" + readUserList +
                '}';
    }
}
