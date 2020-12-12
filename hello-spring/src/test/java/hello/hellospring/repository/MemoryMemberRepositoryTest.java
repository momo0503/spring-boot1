package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

public class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();

	
	@AfterEach
	public void afterEach(){
	repository.clearStore();
	}

	//save 기능이 잘 동작하는지 해본다. 
	@Test
	public void save() {

		Member member = new Member();
		member.setName("spring");
		repository.save(member);
		Member result = repository.findById(member.getId()).get();  //Optional에서 꺼낼때 get()사용

		//검증  member에 직접 정한거랑 DB에서 꺼낸거랑 똑같은지 
		System.out.println("result = " + (result == member)); //단순히 이렇게 해도 된다.
		Assertions.assertEquals(member, result); // org.jupiter.api
		assertThat(member).isEqualTo(result);         //org.assertJ.core.api 
	}


	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		Member result = repository.findByName("spring1").get();
		assertThat(result).isEqualTo(member1);

	}

	@Test 
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		//when
		List<Member> result = repository.findAll();
		//then
		assertThat(result.size()).isEqualTo(2);


	}
}
