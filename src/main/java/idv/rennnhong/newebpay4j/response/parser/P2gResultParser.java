package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public class P2gResultParser extends AbstractResultParser<TradeInfoResult.P2G> {

    private static final String FIELD_P2GTradeNo = "P2GTradeNo";
    private static final String FIELD_P2GPaymentType = "P2GPaymentType";
    private static final String FIELD_P2GAmt = "P2GAmt";

    P2gResultParser() {
        super(TradeInfoResult.P2G.class);
    }

    @Override
    public void parse(TradeInfoResult.P2G tradeInfoResult) {
        tradeInfoResult.setP2gTradeNo(getText(FIELD_P2GTradeNo));
        tradeInfoResult.setP2gPaymentType(getText(FIELD_P2GPaymentType));
        tradeInfoResult.setP2gAmt(getInt(FIELD_P2GAmt));
    }

}
