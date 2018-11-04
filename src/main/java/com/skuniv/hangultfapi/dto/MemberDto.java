package com.skuniv.hangultfapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDto {
    private String id;
    private String token;
    private String password;
    private String name;
    private int age;
}
