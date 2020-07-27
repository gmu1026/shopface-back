package com.dreamsecurity.shopface;

import lombok.*;
import org.springframework.http.HttpStatus;

import javax.websocket.server.ServerEndpoint;

@Getter
@Setter
@NoArgsConstructor
public class Message {
    private String status;
    private String message;
    private Object data;

    @Builder
    public Message (String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}