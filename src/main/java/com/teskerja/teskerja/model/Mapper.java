package com.teskerja.teskerja.model;

public class Mapper {

    public static MemberDto mapToMemberDto(Member member){
        MemberDto memberDto = new MemberDto(
                member.getId(),
                member.getName(),
                member.getDate(),
                member.getEducation(),
                member.getEmail(),
                member.getMobile_no()
        );
        return memberDto;
    }

    public static Member mapToMember(MemberDto memberDto){
        Member member = new Member(
                memberDto.getId(),
                memberDto.getName(),
                memberDto.getDate(),
                memberDto.getEducation(),
                memberDto.getEmail(),
                memberDto.getMobile_no()
        );
        return member;
    }
}
