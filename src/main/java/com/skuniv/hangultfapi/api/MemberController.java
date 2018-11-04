package com.skuniv.hangultfapi.api;

import com.skuniv.hangultfapi.api.responses.BaseResponse;
import com.skuniv.hangultfapi.domain.Member;
import com.skuniv.hangultfapi.dto.MemberDto;
import com.skuniv.hangultfapi.service.Member.MemberNotfoundException;
import com.skuniv.hangultfapi.service.Member.MemberService;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public BaseResponse<MemberDto> getMember(@PathVariable String memberId) {
        try{
            Member member = memberService.getMemberById(memberId);
            return responseFindMemberSuccess(modelMapper.map(member, MemberDto.class));
        }catch (MemberNotfoundException e){
            return responseMemberNotfound();
        }
    }

    /**
     * Get /members/token/{token}.
     * @param token token of app
     * @return BaseResponse<MemberDto>
     */
    @GetMapping("/token/{token}")
    public BaseResponse<String> getMemberByToken(@PathVariable String token) {
        Member member;
        BaseResponse<String> response = new BaseResponse<>();
        try{
            member = memberService.getMemberByToken(token);
            response.setHttpStatus(200);
            response.setMessage("find member success");
            response.setResult(member.getId());
        }
        catch (MemberNotfoundException e){
            response.setHttpStatus(500);
            response.setMessage("member notfound");
        }

        return response;
    }


    /**
     * POST /members.
     * @param memberDto {'id':'password','name','age'}
     * @return created Notice
     */
    @PostMapping
    public BaseResponse<MemberDto> addMember(MemberDto memberDto){
            Member member =  memberService.addMember(modelMapper.map(memberDto,Member.class));
            return responseSignupReturnSuccess(modelMapper.map(member, MemberDto.class));
    }

    private BaseResponse<MemberDto> responseSignupReturnSuccess(MemberDto memberDto) {
        BaseResponse<MemberDto> result = new BaseResponse<>();
        result.setResponseCode(0);
        result.setHttpStatus(200);
        result.setMessage("회원 가입에 성공하였습니다.");
        result.setResult(memberDto);
        return result;
    }

    private BaseResponse<MemberDto> responseSignupReturnFail() {
        BaseResponse<MemberDto> result = new BaseResponse<>();
        result.setResponseCode(0);
        result.setHttpStatus(500);
        result.setMessage("아이디가 이미 존재하는 아이디입니다.");

        return result;
    }

    private BaseResponse<MemberDto> responseMemberNotfound() {
        BaseResponse<MemberDto> result = new BaseResponse<>();
        result.setResponseCode(0);
        result.setHttpStatus(500);
        result.setMessage("해당 아이디의 멤버를 찾지 못하였습니다.");
        result.setResult(new MemberDto());
        return result;
    }

    private BaseResponse<MemberDto> responseFindMemberSuccess(MemberDto memberDto) {
        BaseResponse<MemberDto> result = new BaseResponse<>();
        result.setResponseCode(0);
        result.setHttpStatus(200);
        result.setMessage("해당 아이디의 멤머를 찾았습니다.");
        result.setResult(memberDto);
        return result;
    }


}
