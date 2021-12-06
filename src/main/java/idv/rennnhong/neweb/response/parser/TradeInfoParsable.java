package idv.rennnhong.neweb.response.parser;

import idv.rennnhong.neweb.response.TradeInfo;
import idv.rennnhong.neweb.response.TradeInfoResult;

public interface TradeInfoParsable {

    <T extends TradeInfoResult> TradeInfo<T> parse(String tradeInfoAES) throws Exception;
}
