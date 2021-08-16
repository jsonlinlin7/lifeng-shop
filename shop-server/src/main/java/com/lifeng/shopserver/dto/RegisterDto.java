package com.lifeng.shopserver.dto;



import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterDto {

    private String username;
    private String password;
    private String phone;
    private String secondPassword;
}

