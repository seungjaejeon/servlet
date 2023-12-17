package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save(){
        Member member = new Member("hello", 20);
        Member saveMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(saveMember).isEqualTo(findMember);
    }

    @Test
    void findAll() {
        Member member1 = new Member("kim", 20);
        Member member2 = new Member("lee", 22);
        Member member3 = new Member("park", 24);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        List<Member> memberList = memberRepository.findAll();
        System.out.println("memberList = " + memberList);
        assertEquals(memberList.size(),3);
        Assertions.assertThat(memberList).contains(member1, member2, member3);
    }
}