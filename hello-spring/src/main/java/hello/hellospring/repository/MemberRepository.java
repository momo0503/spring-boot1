package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {
	
	Member save(Member member);
	
	Optional<Member> findById(Long id); //optinal은 자바 8에 들어간 기능인데, findById 로 가져올때 없으면 null인데  null을 그대로 반환하는거보다 optional로 감싸서 담아오는 방식을 선호함.
	
	Optional<Member> findByName(String name);

	List<Member> findAll();
}
