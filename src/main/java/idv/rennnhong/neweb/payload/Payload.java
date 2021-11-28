package idv.rennnhong.neweb.payload;

public class Payload {
    private String merchantID;
    private String version = "1.6";

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
