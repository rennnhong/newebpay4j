package idv.rennnhong.neweb.response.parser;

import idv.rennnhong.neweb.response.TradeInfoResult;

public class CreditResultParser extends AbstractResultParser<TradeInfoResult.Credit> {

    CreditResultParser() {
        super(new TradeInfoResult.Credit());
    }

    @Override
    public void parse(TradeInfoResult.Credit tradeInfoResult) {
        //todo implement [Credit] parser
    }
}
