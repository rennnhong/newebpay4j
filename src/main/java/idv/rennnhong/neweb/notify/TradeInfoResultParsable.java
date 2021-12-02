package idv.rennnhong.neweb.notify;

public interface TradeInfoResultParsable<T extends TradeInfoResult> {

    T parse(String content) throws Exception;
}
