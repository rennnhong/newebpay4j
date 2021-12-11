package idv.rennnhong.newebpay4j.response.parser;

import idv.rennnhong.newebpay4j.response.TradeInfoResult;

public class EsumWalletResultParser extends AbstractResultParser<TradeInfoResult.EsumWallet> {

    private static final String FIELD_PayAmt = "PayAmt";
    private static final String FIELD_RedDisAmt = "RedDisAmt";

    EsumWalletResultParser() {
        super(TradeInfoResult.EsumWallet.class);
    }

    @Override
    public void parse(TradeInfoResult.EsumWallet tradeInfoResult) {
        tradeInfoResult.setPayAmt(getInt(FIELD_PayAmt));
        tradeInfoResult.setRedDisAmt(getInt(FIELD_RedDisAmt));
    }

}
