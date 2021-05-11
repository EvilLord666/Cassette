package com.github.cassette.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "message_status")
public class MessageStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private int code;

}
