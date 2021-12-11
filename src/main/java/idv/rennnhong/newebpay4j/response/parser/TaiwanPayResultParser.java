package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public class TaiwanPayResultParser extends AbstractResultParser<TradeInfoResult.TaiwanPay> {

    private static final String FIELD_PayAmt = "PayAmt";

    TaiwanPayResultParser() {
        super(TradeInfoResult.TaiwanPay.class);
    }

    @Override
    public void parse(TradeInfoResult.TaiwanPay tradeInfoResult) {
        tradeInfoResult.setPayAmt(getInt(FIELD_PayAmt));
    }

}
