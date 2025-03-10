package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService",
            MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService",
            OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository",
            MemberRepository.class);

        //모두 같은 인스턴스를 참고하고 있다.
        System.out.println("memberService -> memberRepository = " +
            memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository = " +
            orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertSame(memberRepository, memberService.getMemberRepository());
        Assertions.assertSame(memberRepository, orderService.getMemberRepository());
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //Appconfig도 스프링 빈으로 등록된다.
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
