package idv.rennnhong.neweb.notify;

public class AtmResultParser extends AbstractResultParser<TradeInfoResult.ATM> {

    private static final String FIELD_PayBankCode = "PayBankCode";
    private static final String FIELD_PayerAccount5Code = "PayerAccount5Code";

    @Override
    public void parse(TradeInfoResult.ATM tradeInfoResult) {
        tradeInfoResult.setPayBankCode(jsonNode.get(FIELD_PayBankCode).asText());
        tradeInfoResult.setPayerAccount5Code(jsonNode.get(FIELD_PayerAccount5Code).asText());
    }

    @Override
    public TradeInfoResult.ATM newInstance() {
        return new TradeInfoResult.ATM();
    }
}
