package com.github.cassette.application.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "message_body_path", nullable = false, length = 300)
    private String messageBodyPath;

    @Column(name = "send_time")
    private LocalDate sendTime;

    @Column(name = "topic", length = 300)
    private String topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "broker_id", nullable = false)
    private BrokerEntity broker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_status_id")
    private MessageStatusEntity messageStatus;
}
