package idv.rennnhong.newebpay4j.response;

import idv.rennnhong.newebpay4j.Trade;

public class TradeResult extends Trade {

    private String success;

    public String getSuccess() {
        return success;
    }

    public TradeResult setSuccess(String success) {
        this.success = success;
        return this;
    }
}
