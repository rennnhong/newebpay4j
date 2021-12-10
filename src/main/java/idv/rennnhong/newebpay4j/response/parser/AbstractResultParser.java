package idv.rennnhong.newebpay4j.response.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import idv.rennnhong.newebpay4j.response.TradeInfoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Optional;

public abstract class AbstractResultParser<T extends TradeInfoResult> implements TradeInfoResultParsable<T> {

    Logger logger = LoggerFactory.getLogger(AbstractResultParser.class);

    final private Class<T> targetResultType;

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

    public AbstractResultParser(Class<T> targetResultType) {
        this.targetResultType = targetResultType;
    }

    @Override
    public T parse(String content) throws Exception {
        jsonNode = om.readValue(content, JsonNode.class);
        T tradeInfoResult = targetResultType.newInstance();
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
        Optional<JsonNode> jsonNode = searchField(fieldName);
        return jsonNode.isPresent() ? jsonNode.get().asText() : "";
    }

    protected Integer getInt(String fieldName) {
        Optional<JsonNode> jsonNode = searchField(fieldName);
        return jsonNode.isPresent() ? jsonNode.get().asInt() : 0;
    }

    private Optional<JsonNode> searchField(String fieldName) {
        Optional<JsonNode> op = Optional.ofNullable(this.jsonNode.get(fieldName));
        if (op.isPresent()) {
            return op;
        }
        logger.warn(MessageFormat.format("the field [{0}] not found!", fieldName));
        return Optional.empty();
    }

}
