package idv.rennnhong.neweb;

public class NewePayTest {

    public static String endpoit = "https://ccore.newebpay.com/MPG/mpg_gateway";
    public static String merchantId = "MS3546495943";

    public static String key = "deckgFiN1n9tuzsFoNBCxnYBy8BJHQsx";
    public static String iv = "CwpcSlJTNNCtciWP";

    public static void main(String[] args) throws Exception {

        TradeBuilder tradeBuilder = TradeBuilder.newBuilder("MS3546495943", "BjM4QQpou5RyheE9TyDtkiHjGyNapQqL", "Pz1n48wopEy8QVfC");
        tradeBuilder.setAmt("52");
        tradeBuilder.setItemDesc("TEST");
        tradeBuilder.setEmail("changerui%40gmail.com");

        Trade trade = tradeBuilder.build();

        System.out.println(trade);

    }


//    public static void main(String[] args) throws Exception {
//        HttpInvoker httpInvoker = new HttpInvoker();
//
//        NewebClient<Payment> client = new NewebPaymentClient(
//                endpoit, httpInvoker, key, iv
//        );
//
//        Payment payment = new Payment();
//        payment.setMerchantID(merchantId);
//
//        String timestamp = Long.toString(new Date().getTime());//時間戳，這邊用來當作訂單編號
//
//        TradeInfo tradeInfo = new TradeInfo();
//        tradeInfo.setMerchantID(merchantId);
//        tradeInfo.setRespondType("JSON");
//        tradeInfo.setTimeStamp(timestamp);
//        tradeInfo.setVersion("1.6");
//        tradeInfo.setMerchantOrderNo(timestamp);
//        tradeInfo.setAmt("52");
//        tradeInfo.setItemDesc("TEST");
//        tradeInfo.setEmail("changerui%40gmail.com");
////        tradeInfo.setLoginType("0");
//
//        payment.setTradeInfo(tradeInfo);
//
//        client.call(payment, new NewebCallback() {
//            @Override
//            public void success(HttpResult httpResult) {
////                System.out.println("成功");
//                System.out.println(httpResult.getHeaders().toString());
//            }
//
//            @Override
//            public void failure(HttpResult httpResult) {
////                System.out.println("失敗");
////                System.out.println(cause);
//            }
//        });
//
//    }
}
