package idv.rennnhong.neweb.response.exception;

import idv.rennnhong.neweb.PaymentType;

import java.text.MessageFormat;

public class NotImplementedException extends RuntimeException {
    public NotImplementedException(PaymentType paymentType) {
        super(MessageFormat.format("the paymentType parser:{0}-{1} hasn't implemented",
                paymentType.getCode(),
                paymentType.getDescription()));
    }
}
