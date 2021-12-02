package idv.rennnhong.neweb.response;

import idv.rennnhong.neweb.Trade;

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
