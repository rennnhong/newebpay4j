package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public class CreditResultParser extends AbstractResultParser<TradeInfoResult.Credit> {
    private static final String FIELD_AuthBank = "AuthBank";
    private static final String FIELD_RespondCode = "RespondCode";
    private static final String FIELD_Auth = "Auth";
    private static final String FIELD_Card6No = "Card6No";
    private static final String FIELD_Card4No = "Card4No";
    private static final String FIELD_Inst = "Inst";
    private static final String FIELD_InstFirst = "InstFirst";
    private static final String FIELD_InstEach = "InstEach";
    private static final String FIELD_ECI = "ECI";
    private static final String FIELD_TokenUseStatus = "TokenUseStatus";
    private static final String FIELD_RedAmt = "RedAmt";
    private static final String FIELD_PaymentMethod = "PaymentMethod";
    private static final String FIELD_DCC_Amt = "DCC_Amt";
    private static final String FIELD_DCC_Rate = "DCC_Rate";
    private static final String FIELD_DCC_Markup = "DCC_Markup";
    private static final String FIELD_DCC_Currency = "DCC_Currency";
    private static final String FIELD_DCC_Currency_Code = "DCC_Currency_Code";
    CreditResultParser() {
        super(TradeInfoResult.Credit.class);
    }
    @Override
    public void parse(TradeInfoResult.Credit tradeInfoResult) {
        tradeInfoResult.setAuthBank(getText(FIELD_AuthBank));
        tradeInfoResult.setRespondCode(getText(FIELD_RespondCode));
        tradeInfoResult.setAuth(getText(FIELD_Auth));
        tradeInfoResult.setCard6No(getText(FIELD_Card6No));
        tradeInfoResult.setCard4No(getText(FIELD_Card4No));
        tradeInfoResult.setInst(getInt(FIELD_Inst));
        tradeInfoResult.setInstFirst(getInt(FIELD_InstFirst));
        tradeInfoResult.setInstEach(getInt(FIELD_InstEach));
        tradeInfoResult.setEci(getText(FIELD_ECI));
        tradeInfoResult.setTokenUseStatus(getInt(FIELD_TokenUseStatus));
        tradeInfoResult.setRedAmt(getInt(FIELD_RedAmt));
        tradeInfoResult.setPaymentMethod(getText(FIELD_PaymentMethod));
        tradeInfoResult.setDccAmt(getInt(FIELD_DCC_Amt));
        tradeInfoResult.setDccRate(getInt(FIELD_DCC_Rate));
        tradeInfoResult.setDccMarkup(getInt(FIELD_DCC_Markup));
        tradeInfoResult.setDccCurrency(getText(FIELD_DCC_Currency));
        tradeInfoResult.setDccCurrencyCode(getInt(FIELD_DCC_Currency_Code));
    }
}
