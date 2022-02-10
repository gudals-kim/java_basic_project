package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();// 아이디와 맴버
    private static Long sequence = 0L; // 아이디가 1 씩 증가하는 시퀀스를 만들거

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){
    }

    public Member save(Member member){//회원 저장 메서드
        member.setId(++sequence); //시퀀스 값을 1 증가시키고
        store.put(member.getId(), member); //멤버를 저장함
        return member;
    }
    public Member findById(Long id){ // 회원 조회 메서드
        return store.get(id);
    }
    public List<Member> findAll(){ //모든 회원 조회
        return new ArrayList<>(store.values());//단 스토어에 저장되어있는 자료를 새로운 리스트에 복사해서 가져온다.
    }

    public void clearStore(){
        store.clear();
    }

}
