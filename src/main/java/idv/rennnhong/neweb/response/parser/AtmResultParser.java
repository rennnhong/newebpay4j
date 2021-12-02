package idv.rennnhong.neweb.response.parser;

import idv.rennnhong.neweb.response.TradeInfoResult;

public class AtmResultParser extends AbstractResultParser<TradeInfoResult.ATM> {

    private static final String FIELD_PayBankCode = "PayBankCode";
    private static final String FIELD_PayerAccount5Code = "PayerAccount5Code";

    public AtmResultParser() {
        super(new TradeInfoResult.ATM());
    }

    @Override
    public void parse(TradeInfoResult.ATM tradeInfoResult) {
        tradeInfoResult.setPayBankCode(jsonNode.get(FIELD_PayBankCode).asText());
        tradeInfoResult.setPayerAccount5Code(jsonNode.get(FIELD_PayerAccount5Code).asText());
    }

}
