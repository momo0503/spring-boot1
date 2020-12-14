package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import hello.hellospring.domain.Member;

public class JdbcTemplateMemberRepository implements MemberRepository {


	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcTemplateMemberRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Member save(Member member) {

		return null;
	}

	@Override
	public Optional<Member> findById(Long id) {

		return null;
	}

	@Override
	public Optional<Member> findByName(String name) {

		return null;
	}

	@Override
	public List<Member> findAll() {

		return null;
	}

}
