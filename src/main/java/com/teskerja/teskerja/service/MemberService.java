package com.teskerja.teskerja.service;

import com.teskerja.teskerja.model.Mapper;
import com.teskerja.teskerja.model.Member;
import com.teskerja.teskerja.model.MemberDto;
import com.teskerja.teskerja.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public void insertMember(MemberDto memberDto){
        memberRepository.insertPersonRepo(memberDto);
    }

    @Transactional
    public List<MemberDto> getAllMembers() {
       return memberRepository.getAllMembersRepo();
    }

    public MemberDto getMember(Long id) {
        return memberRepository.getMemberRepo(id);
    }

    @Transactional
    public void updateMember(MemberDto memberDto) {
        memberRepository.updateMemberRepo(memberDto);
    }

    @Transactional
    public void deleteMember(Long id) {
        memberRepository.deleteMemberRepo(id);
    }
}
