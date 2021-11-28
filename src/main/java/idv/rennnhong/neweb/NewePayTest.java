package idv.rennnhong.neweb;


import idv.rennnhong.neweb.client.NewebCallback;
import idv.rennnhong.neweb.client.NewebClient;
import idv.rennnhong.neweb.client.NewebPaymentClient;
import idv.rennnhong.neweb.http.HttpInvoker;
import idv.rennnhong.neweb.payload.Payment;
import idv.rennnhong.neweb.payload.TradeInfo;

public class NewePayTest {

    public static String endpoit = "http://localhost:8080/";
    public static String merchantId = "MS17361556";

    public static String key = "MCmYlwSGnG1bvT4x7cKPqJSWXuQFjgXd";
    public static String iv = "C5b72pgzdVZofYGP";


    public static void main(String[] args) throws Exception {
        HttpInvoker httpInvoker = new HttpInvoker();

        NewebClient<Payment> client = new NewebPaymentClient(
                endpoit, httpInvoker, key, iv
        );

        Payment payment = new Payment();
        payment.setMerchantID(merchantId);
        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setMerchantID(merchantId);
        tradeInfo.setRespondType("JSON");
        tradeInfo.setTimeStamp("1400137200");
        tradeInfo.setVersion("1.6");
        tradeInfo.setMerchantOrderNo("123456789");
        tradeInfo.setAmt("1000");
        tradeInfo.setItemDesc("藍新測試");
        tradeInfo.setEmail("xxx@gmail.com");
        tradeInfo.setLoginType("0");
        payment.setTradeInfo(tradeInfo);
        payment.setMerchantID("1.6");

        client.call(payment, new NewebCallback() {
            @Override
            public void success(String result) {
                System.out.println("成功");
                System.out.println(result);
            }

            @Override
            public void failure(String cause) {
                System.out.println("失敗");
                System.out.println(cause);
            }
        });

    }
}
