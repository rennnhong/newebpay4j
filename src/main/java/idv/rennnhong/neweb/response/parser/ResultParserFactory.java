package idv.rennnhong.neweb.response.parser;

import idv.rennnhong.neweb.PaymentType;
import idv.rennnhong.neweb.response.TradeInfoResult;

public class ResultParserFactory {

    public static <T extends TradeInfoResult> TradeInfoResultParsable newParser(PaymentType paymentType) {
        switch (paymentType) {
            case WEBATM:
                return new AtmResultParser();
        }
        return null;
    }
}
