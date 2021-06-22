package com.github.cassette.dto;

public class MessageStatusDto {
    public MessageStatusDto() {

    }

    public MessageStatusDto(Long id, String name, Long code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return this.code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    private Long id;
    private String name;
    private Long code;
}