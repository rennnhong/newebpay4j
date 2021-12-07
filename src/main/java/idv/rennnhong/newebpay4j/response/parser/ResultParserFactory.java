package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.PaymentType;
import idv.rennnhong.newebpay4j.response.TradeInfoResult;
import idv.rennnhong.newebpay4j.response.exception.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class ResultParserFactory {

    public static Map<PaymentType, TradeInfoResultParsable> parserMap = new HashMap<>();

    static {
        parserMap.put(PaymentType.WEBATM, new AtmResultParser());
        parserMap.put(PaymentType.CREDIT, new CreditResultParser());
    }

    public static <T extends TradeInfoResult> TradeInfoResultParsable newParser(PaymentType paymentType) {
        TradeInfoResultParsable parser = parserMap.get(paymentType);

        if (parser == null) {
            throw new NotImplementedException(paymentType);
        }

        return parser;
    }
}
