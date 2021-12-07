package idv.rennnhong.newebpay4j.response.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import idv.rennnhong.newebpay4j.response.TradeInfoResult;

import java.util.Optional;

public abstract class AbstractResultParser<T extends TradeInfoResult> implements TradeInfoResultParsable<T> {

    final private T tradeInfoResult;

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

    public AbstractResultParser(T tradeInfoResult) {
        this.tradeInfoResult = tradeInfoResult;
    }

    @Override
    public T parse(String content) throws Exception {
        jsonNode = om.readValue(content, JsonNode.class);
        tradeInfoResult.setMerchantID(getText(FIELD_MerchantID));
        tradeInfoResult.setAmt(getInt(FIELD_Amt));
        tradeInfoResult.setTradeNo(getText(FIELD_TradeNo));
        tradeInfoResult.setMerchantOrderNo(getText(FIELD_MerchantOrderNo));
        tradeInfoResult.setRespondType(getText(FIELD_RespondType));
        tradeInfoResult.setPayTime(getText(FIELD_PayTime));
        tradeInfoResult.setIp(getText(FIELD_IP));
        tradeInfoResult.setEscrowBank(getText(FIELD_EscrowBank));
        parse(tradeInfoResult);
        return tradeInfoResult;
    }

    /*繼承的子類解析特定支付方式的參數*/
    public abstract void parse(T tradeInfoResult);

    protected String getText(String fieldName) {
        JsonNode field = searchField(fieldName);
        if (field == null) {
            return "";
        }
        return field.asText();
    }

    protected Integer getInt(String fieldName) {
        JsonNode field = searchField(fieldName);
        if (field == null) {
            return 0;
        } else {
            return field.asInt();
        }
    }

    private JsonNode searchField(String fieldName) {
        Optional<JsonNode> op = Optional.ofNullable(this.jsonNode.get(fieldName));
        JsonNode field = null;
        if (op.isPresent()) {
            field = op.get();
        }
        return field;
    }

}
