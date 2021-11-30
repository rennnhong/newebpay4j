package idv.rennnhong.neweb;


import idv.rennnhong.neweb.client.NewebCallback;
import idv.rennnhong.neweb.client.NewebClient;
import idv.rennnhong.neweb.client.NewebPaymentClient;
import idv.rennnhong.neweb.http.HttpInvoker;
import idv.rennnhong.neweb.payload.Payment;
import idv.rennnhong.neweb.payload.TradeInfo;

import java.util.Date;

public class NewePayTest {

    public static String endpoit = "https://core.newebpay.com/MPG/mpg_gateway";
    public static String merchantId = "MS3546495943";

    public static String key = "BjM4QQpou5RyheE9TyDtkiHjGyNapQqL";
    public static String iv = "Pz1n48wopEy8QVfC";


    public static void main(String[] args) throws Exception {
        HttpInvoker httpInvoker = new HttpInvoker();

        NewebClient<Payment> client = new NewebPaymentClient(
                endpoit, httpInvoker, key, iv
        );

        Payment payment = new Payment();
        payment.setMerchantID(merchantId);

        String timestamp = Long.toString(new Date().getTime());//時間戳，這邊用來當作訂單編號

        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setMerchantID(merchantId);
        tradeInfo.setRespondType("JSON");
        tradeInfo.setTimeStamp(timestamp);
        tradeInfo.setVersion("1.6");
        tradeInfo.setMerchantOrderNo(timestamp);
        tradeInfo.setAmt("52");
        tradeInfo.setItemDesc("TEST");
        tradeInfo.setEmail("changerui%40gmail.com");
//        tradeInfo.setLoginType("0");

        payment.setTradeInfo(tradeInfo);

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
