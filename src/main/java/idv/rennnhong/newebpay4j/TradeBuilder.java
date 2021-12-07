package idv.rennnhong.newebpay4j;

import idv.rennnhong.newebpay4j.crypto.AES;
import idv.rennnhong.newebpay4j.util.ParamUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TradeBuilder {

    Logger logger = LoggerFactory.getLogger(TradeBuilder.class);

    /*藍新api參數名稱*/
    private final static String MerchantID = "MerchantID";
    private final static String RespondType = "RespondType";
    private final static String TimeStamp = "TimeStamp";
    private final static String Version = "Version";
    private final static String MerchantOrderNo = "MerchantOrderNo";
    private final static String Amt = "Amt";
    private final static String ItemDesc = "ItemDesc";
    private final static String Email = "Email";
    private final static String LoginType = "LoginType";

    private final String merchantID;
    private final String merchantKey;
    private final String merchantIv;

    //client端可設置的參數
    private String version = "1.6";
    private String respondType = "JSON";
    private String merchantOrderNo;
    private String amt;
    private String itemDesc;
    private String email;

    private String timestamp;

    public TradeBuilder(String merchantID, String merchantKey, String merchantIv) {
        this.merchantID = merchantID;
        this.merchantKey = merchantKey;
        this.merchantIv = merchantIv;
    }

    public static TradeBuilder newBuilder(String merchantID, String merchantKey, String merchantIv) {
        return new TradeBuilder(merchantID, merchantKey, merchantIv);
    }

    public TradeBuilder setVersion(String version) {
        this.version = version;
        return this;
    }

    public TradeBuilder setRespondType(String respondType) {
        this.respondType = respondType;
        return this;
    }

    public TradeBuilder setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
        return this;
    }

    public TradeBuilder setAmt(String amt) {
        this.amt = amt;
        return this;
    }

    public TradeBuilder setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
        return this;
    }

    public TradeBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public Trade build() throws Exception {

        this.timestamp = Long.toString(new Date().getTime());

        /*若訂單編號為空，則以時間戳作為訂單編號*/
        if (this.merchantOrderNo == null || "".equals(this.merchantOrderNo)) {
            this.merchantOrderNo = timestamp;
        }

        String tradeInfoContent = this.toQueryString();
        /*將tradeInfo, hashKey, hashIV一起做AES加密*/
        logger.info("encrypt tradeInfo to AES:content={}\nhashKey={}\nhashIV={}", tradeInfoContent, merchantKey, merchantIv);
        String aes = AES.encrypt(tradeInfoContent, merchantKey, merchantIv);
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

        Trade trade = new Trade();
        trade.setMerchantID(this.merchantID);
        trade.setVersion("1.6");
        trade.setTradeInfo(aes);
        trade.setTradeSha(upperCaseSHA256);

        return trade;
    }

    private String toQueryString() {
        Map<String, Object> params = new HashMap<>();
        params.put(MerchantID, this.merchantID);
        params.put(RespondType, this.respondType);
        params.put(TimeStamp, this.timestamp);
        params.put(Version, this.version);
        params.put(MerchantOrderNo, this.merchantOrderNo);
        params.put(Amt, this.amt);
        params.put(ItemDesc, this.itemDesc);
        params.put(Email, this.email);

        return ParamUtils.toKVPair(params);
    }
}
