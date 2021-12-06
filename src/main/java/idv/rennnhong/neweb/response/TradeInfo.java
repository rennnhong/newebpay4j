package idv.rennnhong.neweb.response;

public class TradeInfo<T extends TradeInfoResult> {

    private String status;
    private String message;
    private T result;

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

    public T getResult() {
        return result;
    }

    public TradeInfo<T> setResult(T result) {
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
