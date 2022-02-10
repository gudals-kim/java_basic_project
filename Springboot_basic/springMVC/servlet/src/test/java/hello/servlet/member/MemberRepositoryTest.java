package hello.servlet.member;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){//Test 하나 끝날때마다 초기화하는거
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given (이런걸 주어졌을때)
        Member member = new Member("hello", 20);    
        //when (이런걸 실행 했을때)
        Member saveMember = memberRepository.save(member);
        //then (결과가 이거임)
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember); //찾은 멤버와 저장된 멤버와 값이 같냐?
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 20);

        memberRepository.save(member1); // 멤버 1 저장
        memberRepository.save(member2); // 멤버 2 저장

        //when
        List<Member> result = memberRepository.findAll(); //저장된 모든 멤버를 result리스트에 가져와

        //then
        assertThat(result.size()).isEqualTo(2);//결과가 2 가 맞냐
        assertThat(result).contains(member1,member2); // 리스트 안에 멤버 1 과 2가 있냐
    }


}
