package com.github.cassette.dto;

import com.github.cassette.model.entities.BrokerEntity;
import com.github.cassette.model.entities.MessageStatusEntity;

import java.time.LocalDate;

public class MessageDto {
    public MessageDto() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageBodyPath() {
        return this.messageBodyPath;
    }

    public void setMessageBodyPath(String messageBodyPath) {
        this.messageBodyPath = messageBodyPath;
    }

    public LocalDate getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(LocalDate sendTime) {
        this.sendTime = sendTime;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public BrokerEntity getBroker() {
        return this.broker;
    }

    public void setBroker(BrokerEntity broker) {
        this.broker = broker;
    }

    public MessageStatusEntity getMessageStatus() {
        return this.messageStatus;
    }

    public void setMessageStatus(MessageStatusEntity messageStatus) {
        this.messageStatus = messageStatus;
    }

    private Long id;
    private String messageBodyPath;
    private LocalDate sendTime;
    private String topic;
    private BrokerEntity broker;
    private MessageStatusEntity messageStatus;
}