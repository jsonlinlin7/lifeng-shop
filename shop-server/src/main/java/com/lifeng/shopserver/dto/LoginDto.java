package com.lifeng.shopserver.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginDto {

    private String username;
    private String password;
}

