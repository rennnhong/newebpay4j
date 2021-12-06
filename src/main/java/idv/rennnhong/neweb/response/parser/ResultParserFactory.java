package idv.rennnhong.neweb.response.parser;

import idv.rennnhong.neweb.PaymentType;
import idv.rennnhong.neweb.response.TradeInfoResult;
import idv.rennnhong.neweb.response.exception.NotImplementedException;

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
