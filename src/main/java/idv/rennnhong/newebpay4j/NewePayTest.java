package idv.rennnhong.newebpay4j;

import idv.rennnhong.newebpay4j.response.TradeInfo;
import idv.rennnhong.newebpay4j.response.TradeInfoResult;
import idv.rennnhong.newebpay4j.response.parser.TradeInfoParser;

public class NewePayTest {

    public static String endpoit = "https://ccore.newebpay.com/MPG/mpg_gateway";
    public static String merchantId = "MS327178038";

    public static String key = "deckgFiN1n9tuzsFoNBCxnYBy8BJHQsx";
    public static String iv = "CwpcSlJTNNCtciWP";

    public static void main(String[] args) throws Exception {

//        TradeBuilder tradeBuilder = TradeBuilder.newBuilder(merchantId, key, iv);
//        tradeBuilder.setAmt("52");
//        tradeBuilder.setItemDesc("TEST");
//        tradeBuilder.setEmail("changerui%40gmail.com");
//
//        Trade trade = tradeBuilder.build();
//
//        String tradeInfoStr = trade.getTradeInfo();


//        Response response = new Response();
//
//        response.setSuccess("SUCCESS");
//        response.setMerchantID("MS327178038");
//        response.setTradeInfo("ed89508ab14eb56d43236e4351a6f6df13c7f92aafb416f68e5b13c9f75843968be6e2603f23778690cd80a72041275e8348c68c6ab20e464a561c95fbbed225bda8d52f8c364bcec499f9c2fefc2842b0bd2dca74bd8d8e288b6863f90a527c01ac165eaa708c6988a1f50a4ba88e55be1fe9e154e463cd0e9557ec87f29aba00f7947e06625dc9d47a4b074c4941be4d69a9d098aa878b087e62b6228dfaf228657eb14c5ccf27bc5fce5c320b34a7b9573249651501c9b8dd401d731d7bf2b996c3b950669170c30126d4ce74be96592f01bb29d2a24b111dbc3911218a055aac50d6d82a65b45a151923e1905b195b62d132d7ad95d206145fca7720a277ab2d711aec04fc4a41e10a496486212dfa7cf584b78e98f06dbdd816ff62b846bbf85f02cae47069b51226a4603c1aafb418d86ca9f3f03b305e6380d338ed70aef2fe9154d4b3d14b07bbf1ce4de3359c1b8eb5346da7a89701cde06cfa86de");
//        response.setTradeSha("59FFD0C4833339DF1F1D2C94B950419CDD89022FDF0A0DAFE639C2D33FFC12E7");
//        response.setVersion("1.6");


        PaymentRegistry registry = new PaymentRegisterHandler();
        registry.register(PaymentType.WEBATM);
        registry.register(PaymentType.CREDIT);

        TradeInfoParser tradeInfoParser = new TradeInfoParser(merchantId, key, iv);

        String atmTradeInfo = "ed89508ab14eb56d43236e4351a6f6df13c7f92aafb416f68e5b13c9f75843968be6e2603f23778690cd80a72041275e8348c68c6ab20e464a561c95fbbed225bda8d52f8c364bcec499f9c2fefc2842b0bd2dca74bd8d8e288b6863f90a527c01ac165eaa708c6988a1f50a4ba88e55be1fe9e154e463cd0e9557ec87f29abaf0fd5752dad0f0c09575e40225264fc5dd74a56467b5550837ca470a54be90907fa7ef8a3d6e48471807859b38e6ade2802bffba3d47350ad63f788d004f9d5707e13322aa0be2436a917c81427ffa790ed4cf648a59b8d3c948534e50be22de321d31fe6cbec2559fad79d18f6a92a2f2317f3ab5b5af3b9289ece768a8c512cf7df94b1a02baaf6a26984fde7e6c33bcef3dbf9a06928e3a483ce336d2802abbee38d8b425dae56df476d5b05154c24a7cf955cc6b38b5f70650f9a029fd4ec6f9e96609c4364665afa4b458c4eda3270791a7291fca1f19511bbcdd9dc91a";

        String creditTradeInfo = "ed89508ab14eb56d43236e4351a6f6df13c7f92aafb416f68e5b13c9f7584396a5376456599167e3cc64178cacbb9b20066bee714934dde7d02dc762e013d048f7e854249872219567027d53a8e33736b92fa9828fbef458bde7151b3f0390986d9327da35425b5331b9f767d8d06f7aff5533c7507e3fa2ad618d1abe49785e0c79260950fcc2fbfb770875b1e9c2d69feaf65bb56d4453fd93065bea5a04cb3546f428c09b1add46d2cbed8115cdd7b391c77d810ba3d58861c341f57afab699774f49d283bb0f2778092887c00d8f9b2d2ff3bad97aa5c69c4477b33038b8578a0793360fc3ef13e26fd4c8ce51986bb170f1e5c70c359f6cb7226a2510b0bae387f989507b51d7c506238b32f0458bc1b2023f6ae0430164591a3501f604efd678e4f356212aeb67576cc24c89710fd1b0f4c278ca184dc64dad11895a6c186758f5fbd5da9d0ac33bf8b09babb07cf1f49071dd2d9f40ca4ad4e4fe6a2cbe76ca3c66d01a15ff7a4c9c958a125e78beb45287ce8b96669ada7893da0cae24b62a57a69b2859d74069300a68c303259bfb4a9a9536d23003a68c2d865cecb48f3c1344eebad278a7d528fc227456c7a046739f3549b50d31d288dba907cd93d0e6dd573ccae51772b60eb6b563af57ebea941e119405edb3c6ec60b1426d";

        TradeInfo tradeInfo = tradeInfoParser.parse(atmTradeInfo);
        TradeInfoResult result = tradeInfo.getResult();

        switch (result.getPaymentType()) {
            case WEBATM:
                TradeInfoResult.ATM atm = result.toConcreteType(TradeInfoResult.ATM.class);
                //handle atm......
                break;
            case CREDIT:
                TradeInfoResult.Credit credit = result.toConcreteType(TradeInfoResult.Credit.class);
                //handle credit......
                break;
            default:
        }

        System.out.println(tradeInfo);

    }

}
