package idv.rennnhong.neweb.payload;


public class Payment extends Payload {
    private TradeInfo tradeInfo;

    public TradeInfo getTradeInfo() {
        return tradeInfo;
    }

    public void setTradeInfo(TradeInfo tradeInfo) {
        this.tradeInfo = tradeInfo;
    }

}
