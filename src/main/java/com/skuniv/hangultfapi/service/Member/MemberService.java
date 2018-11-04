package com.skuniv.hangultfapi.service.Member;

import com.skuniv.hangultfapi.domain.Member;
import com.skuniv.hangultfapi.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;


    public Member getMemberById(String id){
        return memberRepository.findMemberById(id).map(member -> {
            return member;
        }).orElseThrow(MemberNotfoundException::new);
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Member getMemberByToken(String token){
        return memberRepository.findMemberByToken(token).map(member -> {
            return member;
        }).orElseThrow(MemberNotfoundException::new);
    }



}
