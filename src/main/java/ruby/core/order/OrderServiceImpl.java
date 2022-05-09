package ruby.core.order;

import org.springframework.stereotype.Service;
import ruby.core.discount.DiscountPolicy;
import ruby.core.member.Member;
import ruby.core.member.MemberRepository;

@Service
public class OrderServiceImpl implements OrderService{

    // 할인 정책을 변경하려면 클라이언트 입장인 해당 클래스에서 코드를 고쳐야 한다.
    // 인터페이스 뿐만 아니라 구현 클래스도 의존하고 있다.  -> DIP 원칙 X
    /*
    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
     */

    // 구현 객체를 외부에서 생성해주고 주입해줘야 한다. -> DIP
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 주문 생성
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
