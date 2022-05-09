package ruby.core.discount;

import org.springframework.stereotype.Service;
import ruby.core.member.Grade;
import ruby.core.member.Member;

@Service
public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1000; // 1000원 할인

    /**
     * 할인 정책
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? discountFixAmount : 0;
    }
}
