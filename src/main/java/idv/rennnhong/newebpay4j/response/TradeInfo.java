package idv.rennnhong.newebpay4j.response;

public class TradeInfo {

    private String status;
    private String message;
    private TradeInfoResult result;

    public String getStatus() {
        return status;
    }

    public TradeInfo setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public TradeInfo setMessage(String message) {
        this.message = message;
        return this;
    }

    public TradeInfoResult getResult() {
        return result;
    }

    public TradeInfo setResult(TradeInfoResult result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "TradeInfo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
