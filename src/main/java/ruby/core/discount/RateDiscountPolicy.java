package ruby.core.discount;

import org.springframework.stereotype.Service;
import ruby.core.member.Grade;
import ruby.core.member.Member;

//@Service
public class RateDiscountPolicy implements DiscountPolicy {

    private final int DISCOUNT_PERCENT = 10;

    /**
     * 할인 정책
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price * DISCOUNT_PERCENT / 100 : 0;
    }
}
