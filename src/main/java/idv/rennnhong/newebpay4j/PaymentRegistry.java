package idv.rennnhong.newebpay4j;

import java.util.Set;

/**
 * 可用支付方式的註冊器
 */
public interface PaymentRegistry {

    void register(PaymentType paymentType);

    void unregister(PaymentType paymentType);

    Set<PaymentType> availablePayments();
}
