package idv.rennnhong.neweb.notify;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import idv.rennnhong.neweb.PaymentType;
import idv.rennnhong.neweb.crypto.AES;

import java.util.HashMap;
import java.util.Map;

public class TradeInfoParser implements TradeInfoParsable {

    private static final String FIELD_Status = "Status";
    private static final String FIELD_Message = "Message";
    private static final String FIELD_Result = "Result";

    private static final String FIELD_PaymentType = "PaymentType";

    private final String merchantID;
    private final String merchantKey;
    private final String merchantIv;

    private Map<PaymentType, TradeInfoResultParsable> parsableMap = new HashMap<>();


    {
        parsableMap.put(PaymentType.WEBATM, new AtmResultParser());
    }

    public TradeInfoParser(String merchantID, String merchantKey, String merchantIv) {
        this.merchantID = merchantID;
        this.merchantKey = merchantKey;
        this.merchantIv = merchantIv;
    }

    /**
     * @param tradeInfoAES TradeInfo的AES加密字串
     * @return
     * @throws Exception
     */
    public TradeInfo parse(String tradeInfoAES) throws Exception {
        /*解析後為tradeInfo內容(json/string)*/
        String tradeInfo = AES.decrypt(tradeInfoAES, merchantKey, merchantIv);
        ObjectMapper om = new ObjectMapper();

        JsonNode rootNode = om.readValue(tradeInfo, JsonNode.class);

        final String status = rootNode.get(FIELD_Status).asText();
        final String message = rootNode.get(FIELD_Message).asText();
        JsonNode resultNode = rootNode.get(FIELD_Result);


        String paymentTypeCode = resultNode.get(FIELD_PaymentType).asText();
        PaymentType paymentType = PaymentType.valueOfCode(paymentTypeCode);

        /*透過paymentType選擇解析器*/
        TradeInfoResultParsable<TradeInfoResult.ATM> parser = parsableMap.get(paymentType);

        TradeInfoResult.ATM tir = parser.parse(resultNode.toString());

        TradeInfo ti = new TradeInfo();
        ti.setStatus(status);
        ti.setMessage(message);
        ti.setResult(tir);

        return ti;
    }


}
