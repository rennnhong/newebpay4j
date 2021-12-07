package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfo;
import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public interface TradeInfoParsable {

    <T extends TradeInfoResult> TradeInfo<T> parse(String tradeInfoAES) throws Exception;
}
