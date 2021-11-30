//package idv.rennnhong.neweb.client;
//
//import idv.rennnhong.neweb.http.HttpInvoker;
//
///**
// *  API調用的Client抽象類
// * @param <T> Payload的類型
// */
//public abstract class NewebClient<T> {
//
//    protected final String endpoint;
//
//    protected final HttpInvoker http;
//
//    public NewebClient(String endpoint, HttpInvoker http) {
//        this.endpoint = endpoint;
//        this.http = http;
//    }
//
//    public abstract void call(T payload, NewebCallback callback) throws Exception;
//
//}
