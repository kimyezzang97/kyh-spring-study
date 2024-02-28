package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // 1. 그냥 사용 방법
        // MemberService memberService = new MemberServiceImpl();

        // 2. DI 적용 방법
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();

        // 3.스프링 컨테이너 호출 및 적용 방법
        // AppConfig (@Configuration) 의 환경설정 정보를 가지고 spring 컨테이너 생성
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // Bean 으로 등록 된 memberService() 메서드를 키로 하여 호출 ac.getBean(key, requiredType : return 타입)
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP); // cmd + opt + v : 변수명 자동 선언
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName()); // soutv ㄷㄷ 변수 명까지 가져옴

    }
}
