package idv.rennnhong.newebpay4j.response.exception;

import idv.rennnhong.newebpay4j.PaymentType;

import java.text.MessageFormat;

public class NotImplementedException extends RuntimeException {
    public NotImplementedException(PaymentType paymentType) {
        super(MessageFormat.format("the paymentType parser:{0}-{1} has not implemented",
                paymentType.getCode(),
                paymentType.getDescription()));
    }
}
