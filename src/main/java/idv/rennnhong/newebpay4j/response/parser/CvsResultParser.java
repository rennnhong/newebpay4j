package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public class CvsResultParser extends AbstractResultParser<TradeInfoResult.CVS> {
    private static final String FIELD_CodeNo = "CodeNo";
    private static final String FIELD_StoreType = "StoreType";
    private static final String FIELD_StoreID = "StoreID";

    public CvsResultParser() {
        super(new TradeInfoResult.CVS());
    }

    @Override
    public void parse(TradeInfoResult.CVS tradeInfoResult) {
        tradeInfoResult.setCodeNo(getText(FIELD_CodeNo));
        tradeInfoResult.setStoreType(getInt(FIELD_StoreType));
        tradeInfoResult.setStoreID(getText(FIELD_StoreID));
    }
}
