package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public class BarCodeResultParser extends AbstractResultParser<TradeInfoResult.BARCODE> {

    private static final String FIELD_Barcode_1 = "Barcode_1";
    private static final String FIELD_Barcode_2 = "Barcode_2";
    private static final String FIELD_Barcode_3 = "Barcode_3";
    private static final String FIELD_PayStore = "PayStore";

    public BarCodeResultParser() {
        super(TradeInfoResult.BARCODE.class);
    }

    @Override
    public void parse(TradeInfoResult.BARCODE tradeInfoResult) {
        tradeInfoResult.setBarcode_1(getText(FIELD_Barcode_1));
        tradeInfoResult.setBarcode_2(getText(FIELD_Barcode_2));
        tradeInfoResult.setBarcode_3(getText(FIELD_Barcode_3));
        tradeInfoResult.setPayStore(getText(FIELD_PayStore));
    }
}
