package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import hello.hellospring.domain.Member;

@Repository

public class MemoryMemberRepository implements MemberRepository {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L; 

	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {

		return Optional.ofNullable(store.get(id)); //요즘엔 null이 반환된 가능성이 있으면 Optional 을써준다. 감싸서 반환해준다.
	}

	@Override
	public Optional<Member> findByName(String name) {

		return store.values().stream()
				.filter(member -> member.getName().equals(name))
				.findAny();
	}

	@Override
	public List<Member> findAll() {

		return new ArrayList<>(store.values()); //store.values 는 store에있는 값들 , 즉 Member 값들
	}


	public void clearStore(){
		store.clear();
	}
}
