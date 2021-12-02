package idv.rennnhong.neweb.response.parser;

import idv.rennnhong.neweb.response.TradeInfo;

public interface TradeInfoParsable {

    TradeInfo parse(String content) throws Exception;
}
