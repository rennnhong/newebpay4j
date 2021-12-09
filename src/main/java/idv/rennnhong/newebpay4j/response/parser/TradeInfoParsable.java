package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfo;

public interface TradeInfoParsable {

    TradeInfo parse(String tradeInfoAES) throws Exception;
}
