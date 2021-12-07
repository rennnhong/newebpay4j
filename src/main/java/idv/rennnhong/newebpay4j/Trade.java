package idv.rennnhong.newebpay4j;

public class Trade {

    private String merchantID;

    private String version;

    private String tradeInfo;

    private String tradeSha;

    public String getMerchantID() {
        return merchantID;
    }

    public Trade setMerchantID(String merchantID) {
        this.merchantID = merchantID;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public Trade setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getTradeInfo() {
        return tradeInfo;
    }

    public Trade setTradeInfo(String tradeInfo) {
        this.tradeInfo = tradeInfo;
        return this;
    }

    public String getTradeSha() {
        return tradeSha;
    }

    public Trade setTradeSha(String tradeSha) {
        this.tradeSha = tradeSha;
        return this;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "merchantID='" + merchantID + '\'' +
                ", version='" + version + '\'' +
                ", tradeInfo='" + tradeInfo + '\'' +
                ", tradeSha='" + tradeSha + '\'' +
                '}';
    }
}
