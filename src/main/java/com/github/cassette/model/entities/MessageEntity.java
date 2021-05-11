package com.github.cassette.model.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "message")
public class MessageEntity extends BaseEntity {
    
    public MessageEntity() {
        
    }
    
    public MessageEntity(String messageBodyPath, LocalDate sendTime, String topic, BrokerEntity broker, MessageStatusEntity messageStatus) {
        this.messageBodyPath = messageBodyPath;
        this.sendTime = sendTime;
        this.topic = topic;
        this.broker = broker;
        this.messageStatus = messageStatus;
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
    
    public BrokerEntity getBroker() {
        return this.broker;
    }
    

    @Column(name = "message_body_path", nullable = false, length = 300)
    private String messageBodyPath;

    @Column(name = "send_time", nullable = true)
    private LocalDate sendTime;

    @Column(name = "topic", length = 300, nullable = true)
    private String topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "broker_id", nullable = false)
    private BrokerEntity broker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_status_id", nullable = true)
    private MessageStatusEntity messageStatus;
}
