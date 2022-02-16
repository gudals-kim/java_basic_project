package com.example.myservlet.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    //store라는 해쉬맵을 만든다.
    private static Map<Long , Member> store = new HashMap<>();
    //ID를 부여하는 sequence를 만든다.
    private static long sequence = 0L;

    //싱글톤 패턴으로 구현해야하기때문에 (객체를 다 같이 써야한다) private로 선언한다
    private MemberRepository(){};
    private static final MemberRepository instance = new MemberRepository();
    public static MemberRepository getInstance(){
        return instance;
    }
    //싱글톤 패턴 끝


    public Member save(Member member){
        member.setId(++sequence);//멤버 객체에 ID를 부여한다.
        store.put(member.getId(), member);//멤버 아이디(key)와 멤버를 store에 저장한다.
        return member;
    }

    public Member findById(Long id){//아이디로 멤버를 찾음
        return store.get(id);//key(id)로 value(멤버)를 리턴
    }

    public List<Member> findAll(){//저장된 모든 멤버
        return new ArrayList<>(store.values());//store에 있는 모든 value(멤버) 리턴
    }

    public void clearStore(){//초기화
        store.clear();
    }




}
