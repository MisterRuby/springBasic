package ruby.core.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ruby.core.member.Grade;
import ruby.core.member.Member;
import ruby.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    MemberService memberService;
    @Autowired
    OrderService orderService;

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 100000);

        assertThat(order.getItemPrice()).isEqualTo(100000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}