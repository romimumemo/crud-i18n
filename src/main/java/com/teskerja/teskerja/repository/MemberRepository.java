package com.teskerja.teskerja.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.teskerja.teskerja.model.Mapper;
import com.teskerja.teskerja.model.Member;
import com.teskerja.teskerja.model.MemberDto;
import com.teskerja.teskerja.model.QMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemberRepository {

    @Autowired
    private EntityManager entityManager;

    public List<MemberDto> getAllMembersRepo() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QMember memberq = QMember.member;
        List<Member> member = queryFactory.selectFrom(memberq)
                .orderBy(memberq.id.asc())
                .fetch();
        List<MemberDto> memberDtos = member.stream()
                .map((item) -> Mapper.mapToMemberDto(item))
                .collect(Collectors.toList());
        return memberDtos;
    }

    public void insertPersonRepo(MemberDto memberDto){
        Member member = Mapper.mapToMember(memberDto);
        entityManager.persist(member);
    }

    public MemberDto getMemberRepo(Long id) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QMember memberq = QMember.member;
        Member member = queryFactory.selectFrom(memberq)
                .where(memberq.id.eq(id))
                .fetchOne();
        MemberDto memberDtos = Mapper.mapToMemberDto(member);
        return memberDtos;
    }

    public void updateMemberRepo(MemberDto memberDto) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QMember memberq = QMember.member;
        queryFactory.update(memberq).where(memberq.id.eq(memberDto.getId()))
                .set(memberq.name, memberDto.getName())
                .set(memberq.date, memberDto.getDate())
                .set(memberq.education, memberDto.getEducation())
                .set(memberq.email, memberDto.getEmail())
                .set(memberq.mobile_no, memberDto.getMobile_no())
                .execute();
    }

    public void deleteMemberRepo(Long id) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QMember memberq = QMember.member;
        queryFactory.delete(memberq).where(memberq.id.eq(id)).execute();
    }


    public List<Member> findPeopleByName(String name) {
        Member member1 = new Member();
        member1.setName("John");
        entityManager.persist(member1);

        Member member2 = new Member();
        member2.setName("Jane");
        entityManager.persist(member2);

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QMember member = QMember.member;
        return queryFactory.selectFrom(member)
                .where(member.name.eq(name))
                .fetch();
    }



}
