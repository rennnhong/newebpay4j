package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public class AliPayResultParser extends AbstractResultParser<TradeInfoResult.AliPay> {

    private static final String FIELD_ChannelID = "ChannelID";
    private static final String FIELD_ChannelNo = "ChannelNo";

    AliPayResultParser() {
        super(TradeInfoResult.AliPay.class);
    }

    @Override
    public void parse(TradeInfoResult.AliPay tradeInfoResult) {
        tradeInfoResult.setChannelID(getText(FIELD_ChannelID));
        tradeInfoResult.setChannelID(getText(FIELD_ChannelNo));
    }

}
