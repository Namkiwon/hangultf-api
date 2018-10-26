package com.skuniv.hangultfapi.service.Member;

public class MemberNotfoundException extends RuntimeException {
    public MemberNotfoundException(){
        super("해당 멤버를 찾을 수 없습니다.");
    }
}
