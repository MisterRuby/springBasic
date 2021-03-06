package ruby.core.discount;

import ruby.core.member.Member;

public interface DiscountPolicy {

    /**
     * 할인 정책
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
