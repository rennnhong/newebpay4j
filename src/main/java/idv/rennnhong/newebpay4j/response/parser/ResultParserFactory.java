package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.PaymentType;
import idv.rennnhong.newebpay4j.response.TradeInfoResult;
import idv.rennnhong.newebpay4j.response.exception.NotImplementedException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ResultParserFactory {

    /**
     * 存放所有解析器的supplier，當支付方式被註冊之後調用對應的supplier來new出parser
     */
    public static Map<PaymentType, Supplier<TradeInfoResultParsable>> parserSupplierMap = new HashMap<>();


    /**
     * 存放所有經過註冊的可用解析器
     */
    public static Map<PaymentType, TradeInfoResultParsable> parserMap = new HashMap<>();

    static {
        /*建立所有解析器的supplier*/
        parserSupplierMap.put(PaymentType.WEBATM, () -> new AtmResultParser());
        parserSupplierMap.put(PaymentType.CREDIT, () -> new CreditResultParser());
    }

    public static <T extends TradeInfoResult> TradeInfoResultParsable newParser(PaymentType paymentType) {
        TradeInfoResultParsable parser = parserMap.get(paymentType);

        if (parser == null) {
            throw new NotImplementedException(paymentType);
        }

        return parser;
    }
}
