package idv.rennnhong.neweb.client;

import idv.rennnhong.neweb.crypto.AES;
import idv.rennnhong.neweb.http.HttpInvoker;
import idv.rennnhong.neweb.http.HttpResult;
import idv.rennnhong.neweb.payload.Payment;
import idv.rennnhong.neweb.payload.TradeInfo;
import idv.rennnhong.neweb.util.ParamUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * API調用的Client實作-多功能收款
 */
public class NewebPaymentClient extends NewebClient<Payment> {

    Logger logger = LoggerFactory.getLogger(NewebPaymentClient.class);

    private String merchantKey;

    private String merchantIv;

    public NewebPaymentClient(String endpoint, HttpInvoker http, String merchantKey, String merchantIv) {
        super(endpoint, http);
        this.merchantKey = merchantKey;
        this.merchantIv = merchantIv;
    }

    @Override
    public void call(Payment payload, NewebCallback callback) throws Exception {

        TradeInfo tradeInfo = payload.getTradeInfo();
        String tradeInfoContent = tradeInfo.toQueryString();
        /*將tradeInfo, hashKey, hashIV一起做AES加密*/
        logger.info("encrypt tradeInfo to AES:content={}\nhashKey={}\nhashIV={}", tradeInfoContent, merchantKey, merchantIv);
        String aes = AES.Encrypt(tradeInfoContent, merchantKey, merchantIv);
        logger.info("tradeInfoAES:{}", aes);

        String[] strArr = new String[3];
        strArr[0] = "HashKey=" + merchantKey;
        strArr[1] = aes;
        strArr[2] = "HashIV=" + merchantIv;
        String beforeSHA256 = StringUtils.join(strArr, "&");
        logger.info("encrypt tradeInfoAES to SHA256:content={}", beforeSHA256);
        /*將tradeInfo的AES加密字串頭尾分別加上hashKey和hashIV，注意加上的都必須是K/V pair*/
        String afterSHA256 = DigestUtils.sha256Hex(beforeSHA256);
        logger.info("tradeInfoSHA256:{}", afterSHA256);
        String upperCaseSHA256 = afterSHA256.toUpperCase();
        logger.info("tradeInfoSHA256(UpperCase):{}", upperCaseSHA256);

        Map<String, Object> payloadMap = new HashMap<>();
        payloadMap.put("MerchantID", payload.getMerchantID());
        payloadMap.put("TradeInfo", aes);
        payloadMap.put("TradeSha", upperCaseSHA256);
        payloadMap.put("Version", payload.getVersion());

        String content = ParamUtils.toKVPair(payloadMap);

        HttpResult result = http.post(endpoint, content);

        System.out.println(result.getCode());
        System.out.println(result.getBody());

        if (result.getCode() >= 200 && result.getCode() < 300) {
            callback.success(result.getBody());
        } else {
            callback.failure(result.getBody());
        }

    }


}
