package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest //스프링 컨테이너 안에서 테스트
@Transactional //테스트에 있는 트랜잭션은 테스트 후 롤백
class MemberServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long saveId = memberService.join(member);

        //then
        Assertions.assertEquals(member, memberRepository.findOne(saveId));
    }
    
    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        try {
            memberService.join(member2); // 예외 발생
        } catch (IllegalStateException e) {
            return;
        }

        //then
        Assertions.fail("예외 발생"); // 예외가 발생해서 이 코드가 실행되면 안 됨
    }

}
