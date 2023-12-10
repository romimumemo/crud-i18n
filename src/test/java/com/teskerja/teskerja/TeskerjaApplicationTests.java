package com.teskerja.teskerja;

import com.teskerja.teskerja.model.Member;
import com.teskerja.teskerja.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
//@ActiveProfiles("test")
@Transactional
class TeskerjaApplicationTests {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private EntityManager entityManager;

	@Test
	void testFindPeopleByName() {
		System.out.println("bai");
//		Member member1 = new Member();
//		member1.setName("John");
//		entityManager.persist(member1);
//
//		Member member2 = new Member();
//		member2.setName("Jane");
//		entityManager.persist(member2);
//
//		List<Member> result = memberRepository.findPeopleByName("John");
//
//		System.out.println("Jumlah data : " + result.size());
//		System.out.println("Nama : " + result.get(0).getName());

//		assertThat(result).hasSize(1);
//		assertThat(result.get(0).getFirstName()).isEqualTo("John");
//		assertThat(result.get(0).getLastName()).isEqualTo("Smith");
	}

}
