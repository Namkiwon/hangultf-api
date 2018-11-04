package com.skuniv.hangultfapi.repositories;

import com.skuniv.hangultfapi.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findMemberById(String id);

    Optional<Member> findMemberByToken(String token);
}
