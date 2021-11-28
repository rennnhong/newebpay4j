package idv.rennnhong.neweb.client;

/**
 * 串接NewebPay API的回調
 */
public interface NewebCallback {

    void success(String result);

    void failure(String cause);
}
