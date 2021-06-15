package com.github.cassette.dto;

import com.github.cassette.model.entities.BrokerEntity;
import com.github.cassette.model.entities.MessageStatusEntity;

public class MessageDto {
    public MessageDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageBodyPath() {
        return messageBodyPath;
    }

    public void setMessageBodyPath(String messageBodyPath) {
        this.messageBodyPath = messageBodyPath;
    }

    public LocalDate getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDate sendTime) {
        this.sendTime = sendTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public BrokerEntity getBroker() {
        return broker;
    }

    public void setBroker(BrokerEntity broker) {
        this.broker = broker;
    }

    public MessageStatusEntity getMessageStatus() {
        return messageStatus;
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
