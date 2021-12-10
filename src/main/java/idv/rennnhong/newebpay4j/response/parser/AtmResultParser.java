package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public class AtmResultParser extends AbstractResultParser<TradeInfoResult.ATM> {

    private static final String FIELD_PayBankCode = "PayBankCode";
    private static final String FIELD_PayerAccount5Code = "PayerAccount5Code";

    AtmResultParser() {
        super(TradeInfoResult.ATM.class);
    }

    @Override
    public void parse(TradeInfoResult.ATM tradeInfoResult) {
        tradeInfoResult.setPayBankCode(getText(FIELD_PayBankCode));
        tradeInfoResult.setPayerAccount5Code(getText(FIELD_PayerAccount5Code));
    }

}
