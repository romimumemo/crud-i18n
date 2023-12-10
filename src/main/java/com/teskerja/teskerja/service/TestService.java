package com.teskerja.teskerja.service;

import com.teskerja.teskerja.model.Member;
import com.teskerja.teskerja.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private MemberRepository memberRepository;

//    @Transactional
//    public List<Member> testRepo(String name){
//        return memberRepository.findPeopleByName(name);
//    }
}
