package ruby.core.order;

public interface OrderService {

    /**
     * 주문 생성
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
