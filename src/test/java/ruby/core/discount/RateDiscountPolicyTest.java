//package ruby.core.discount;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import ruby.core.member.Grade;
//import ruby.core.member.Member;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//class RateDiscountPolicyTest {
//
//    @Autowired
//    RateDiscountPolicy rateDiscountPolicy;
//
//    @Test
//    void rateDiscountPolicyByVIP() {
//        Member member = new Member(1L, "memberVIP", Grade.VIP);
//
//        int discount = rateDiscountPolicy.discount(member, 10000);
//
//        assertThat(discount).isEqualTo(1000);
//    }
//
//    @Test
//    void rateDiscountPolicyByBasic() {
//        Member member = new Member(1L, "memberBasic", Grade.BASIC);
//
//        int discount = rateDiscountPolicy.discount(member, 10000);
//
//        assertThat(discount).isEqualTo(0);
//    }
//}