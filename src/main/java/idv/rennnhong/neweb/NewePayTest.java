package idv.rennnhong.neweb;

import idv.rennnhong.neweb.response.TradeInfo;
import idv.rennnhong.neweb.response.parser.TradeInfoParser;

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


        TradeInfoParser tradeInfoParser = new TradeInfoParser(merchantId, key, iv);

        TradeInfo tradeInfo = tradeInfoParser.parse("ed89508ab14eb56d43236e4351a6f6df13c7f92aafb416f68e5b13c9f75843968be6e2603f23778690cd80a72041275e8348c68c6ab20e464a561c95fbbed225bda8d52f8c364bcec499f9c2fefc2842b0bd2dca74bd8d8e288b6863f90a527c01ac165eaa708c6988a1f50a4ba88e55be1fe9e154e463cd0e9557ec87f29aba00f7947e06625dc9d47a4b074c4941be4d69a9d098aa878b087e62b6228dfaf228657eb14c5ccf27bc5fce5c320b34a7b9573249651501c9b8dd401d731d7bf2b996c3b950669170c30126d4ce74be96592f01bb29d2a24b111dbc3911218a055aac50d6d82a65b45a151923e1905b195b62d132d7ad95d206145fca7720a277ab2d711aec04fc4a41e10a496486212dfa7cf584b78e98f06dbdd816ff62b846bbf85f02cae47069b51226a4603c1aafb418d86ca9f3f03b305e6380d338ed70aef2fe9154d4b3d14b07bbf1ce4de3359c1b8eb5346da7a89701cde06cfa86de");

        System.out.println(tradeInfo);

    }

}
