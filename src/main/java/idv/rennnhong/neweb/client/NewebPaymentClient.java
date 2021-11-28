package idv.rennnhong.neweb.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import idv.rennnhong.neweb.crypto.AES;
import idv.rennnhong.neweb.http.HttpInvoker;
import idv.rennnhong.neweb.http.HttpResult;
import idv.rennnhong.neweb.payload.Payment;
import idv.rennnhong.neweb.payload.TradeInfo;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * API調用的Client實作-多功能收款
 */
public class NewebPaymentClient extends NewebClient<Payment> {

    private String merchantKey;

    private String merchantIv;

    public NewebPaymentClient(String endpoint, HttpInvoker http, String merchantKey, String merchantIv) {
        super(endpoint, http);
        this.merchantKey = merchantKey;
        this.merchantIv = merchantIv;
    }

    @Override
    public void call(Payment payload, NewebCallback callback) throws Exception {


        ObjectMapper om = new ObjectMapper();
        ObjectNode objectNode = om.createObjectNode();

        TradeInfo tradeInfo = payload.getTradeInfo();
        String s = tradeInfo.toQueryString();
        String aes = AES.Encrypt(s, merchantKey, merchantIv);

        String sha256 = new String(DigestUtils.sha256(merchantKey + aes + merchantIv));
        objectNode.put("MerchantID", payload.getMerchantID());
        objectNode.put("TradeInfo", aes);
        objectNode.put("TradeSha", sha256);
        objectNode.put("Version", payload.getVersion());

        HttpResult result = http.post(endpoint, om.writeValueAsString(objectNode));

        if (result.getCode() >= 200 && result.getCode() < 300){
            callback.success(result.getBody());
        }
        else{
            callback.failure(result.getBody());
        }

    }


}
