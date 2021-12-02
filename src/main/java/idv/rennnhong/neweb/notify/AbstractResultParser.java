package idv.rennnhong.neweb.notify;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractResultParser<T extends TradeInfoResult> implements TradeInfoResultParsable<T> {

    protected T tradeInfoResult;

    protected JsonNode jsonNode;

    protected ObjectMapper om = new ObjectMapper();

    private static final String FIELD_MerchantID = "MerchantID";
    private static final String FIELD_Amt = "Amt";
    private static final String FIELD_TradeNo = "TradeNo";
    private static final String FIELD_MerchantOrderNo = "MerchantOrderNo";
    private static final String FIELD_RespondType = "RespondType";
    private static final String FIELD_PayTime = "PayTime";
    private static final String FIELD_IP = "IP";
    private static final String FIELD_EscrowBank = "EscrowBank";

    @Override
    public T parse(String content) throws Exception {
        tradeInfoResult = newInstance();
        jsonNode = om.readValue(content, JsonNode.class);
        tradeInfoResult.setMerchantID(jsonNode.get(FIELD_MerchantID).asText());
        tradeInfoResult.setAmt(jsonNode.get(FIELD_Amt).asInt());
        tradeInfoResult.setTradeNo(jsonNode.get(FIELD_TradeNo).asText());
        tradeInfoResult.setMerchantOrderNo(jsonNode.get(FIELD_MerchantOrderNo).asText());
        tradeInfoResult.setRespondType(jsonNode.get(FIELD_RespondType).asText());
        tradeInfoResult.setPayTime(jsonNode.get(FIELD_PayTime).asText());
        tradeInfoResult.setIp(jsonNode.get(FIELD_IP).asText());
        tradeInfoResult.setEscrowBank(jsonNode.get(FIELD_EscrowBank).asText());
        parse(tradeInfoResult);
        return tradeInfoResult;
    }

    /*繼承的子類解析特定支付方式的參數*/
    public abstract void parse(T tradeInfoResult);

    /*繼承的子類創建特定支付方式的物件*/
    public abstract T newInstance();

}
