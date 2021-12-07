package idv.rennnhong.newebpay4j;

import idv.rennnhong.newebpay4j.response.parser.ResultParserFactory;
import idv.rennnhong.newebpay4j.response.parser.TradeInfoResultParsable;

import java.util.Set;
import java.util.function.Supplier;

public class PaymentRegisterHandler implements PaymentRegistry {

    @Override
    public void register(PaymentType paymentType) {
        Supplier<TradeInfoResultParsable> tradeInfoResultParsableSupplier = ResultParserFactory.parserSupplierMap.get(paymentType);
        TradeInfoResultParsable tradeInfoResultParsable = tradeInfoResultParsableSupplier.get();
        ResultParserFactory.parserMap.put(paymentType, tradeInfoResultParsable);
    }

    @Override
    public void unregister(PaymentType paymentType) {
        ResultParserFactory.parserMap.remove(paymentType);
    }

    @Override
    public Set<PaymentType> availablePayments() {
        return ResultParserFactory.parserMap.keySet();
    }

}
