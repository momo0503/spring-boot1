package hello.hellospring.repository;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.domain.Member;

@Primary
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository{
	
	Optional<Member> findByName(String name);

}
