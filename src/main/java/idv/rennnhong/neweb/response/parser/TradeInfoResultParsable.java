package idv.rennnhong.neweb.response.parser;

import idv.rennnhong.neweb.response.TradeInfoResult;

public interface TradeInfoResultParsable<T extends TradeInfoResult> {

    T parse(String content) throws Exception;
}
