package com.skuniv.hangultfapi.api;

import com.skuniv.hangultfapi.domain.Member;
import com.skuniv.hangultfapi.dto.MemberDto;
import com.skuniv.hangultfapi.service.Member.MemberService;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.NotNull;

@Getter
@Setter
@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    MemberService memberService;

    private ModelMapper modelMapper;

    public MemberController() {
        this.modelMapper = new ModelMapper();
    }

    /**
     * GET /members/{memberId}.
     * @param memberId id of notices
     * @return Member
     */
    @GetMapping("/{memberId}")
    public MemberDto getMember(@PathVariable String memberId) {
        Member member = memberService.getMemberById(memberId);
        return modelMapper.map(member, MemberDto.class);
    }

    /**
     * POST /members.
     * @param memberDto {'id':'password','name','age'}
     * @return created Notice
     */
    @PostMapping
    public MemberDto addMember(@RequestBody MemberDto memberDto){
        Member member =  memberService.addMember(modelMapper.map(memberDto,Member.class));
        return modelMapper.map(member,MemberDto.class);
    }


}
