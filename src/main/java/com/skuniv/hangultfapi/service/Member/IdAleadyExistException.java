package com.skuniv.hangultfapi.service.Member;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class IdAleadyExistException extends MySQLIntegrityConstraintViolationException {
    public IdAleadyExistException(){
        super("해당 Id가 이미 존재합니다.");
    }
}
