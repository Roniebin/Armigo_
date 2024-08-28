package org.example.virtualfittingshop.domain.member.dto;

import lombok.Data;

@Data
public class RequestLogin {
    private String name;
    private String password;
}
