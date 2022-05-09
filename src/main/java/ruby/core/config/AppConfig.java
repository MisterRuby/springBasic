//package ruby.core.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import ruby.core.discount.DiscountPolicy;
//import ruby.core.discount.RateDiscountPolicy;
//import ruby.core.member.MemberService;
//import ruby.core.member.MemberServiceImpl;
//import ruby.core.member.MemoryMemberRepository;
//import ruby.core.order.OrderService;
//import ruby.core.order.OrderServiceImpl;
//
///**
// * 빈의 이름은 항상 다른 이름을 부여하는 것이 좋다.
// *  - 같은 이름을 부여하면 다른 빈이 무시되거나 기존 빈을 덮어버리는 등 설정에 따라 오류가 발생
// */
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    @Bean
//    public OrderService orderService() {
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }
//
//    @Bean
//    public MemoryMemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//
//    /**
//     * 할인 정책을 변경하고 싶다면 해당 메서드에서 리턴 값만 변경해주면 된다.
//     *  변경된 할인 정책이 주입받는 다른 빈 객체에도 적용이 된다.
//     * @return
//     */
//    @Bean
//    public DiscountPolicy discountPolicy() {
////        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
//    }
//}
