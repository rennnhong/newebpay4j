package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public class CvscomResultParser extends AbstractResultParser<TradeInfoResult.CVSCOM> {

    private static final String FIELD_StoreCode = "StoreCode";
    private static final String FIELD_StoreName = "StoreName";
    private static final String FIELD_StoreType = "StoreType";
    private static final String FIELD_StoreAddr = "StoreAddr";
    private static final String FIELD_TradeType = "TradeType";
    private static final String FIELD_CVSCOMName = "CVSCOMName";
    private static final String FIELD_CVSCOMPhone = "CVSCOMPhone";
    private static final String FIELD_LgsNo = "LgsNo";

    CvscomResultParser() {
        super(TradeInfoResult.CVSCOM.class);
    }

    @Override
    public void parse(TradeInfoResult.CVSCOM tradeInfoResult) {
        tradeInfoResult.setStoreCode(getText(FIELD_StoreCode));
        tradeInfoResult.setStoreName(getText(FIELD_StoreName));
        tradeInfoResult.setStoreType(getText(FIELD_StoreType));
        tradeInfoResult.setStoreAddr(getText(FIELD_StoreAddr));
        tradeInfoResult.setTradeType(getInt(FIELD_TradeType));
        tradeInfoResult.setCvscomName(getText(FIELD_CVSCOMName));
        tradeInfoResult.setCvscomPhone(getText(FIELD_CVSCOMPhone));
        tradeInfoResult.setLgsNo(getText(FIELD_LgsNo));
    }

}
