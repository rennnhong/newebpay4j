package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public interface TradeInfoResultParsable<T extends TradeInfoResult> {

    T parse(String content) throws Exception;
}
