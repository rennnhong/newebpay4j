package idv.rennnhong.neweb.payload;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TradeInfo {

    Map<String, String> params = new HashMap<>();

    private final static String MerchantID = "MerchantID";
    private final static String RespondType = "RespondType";
    private final static String TimeStamp = "TimeStamp";
    private final static String Version = "Version";
    private final static String MerchantOrderNo = "MerchantOrderNo";
    private final static String Amt = "Amt";
    private final static String ItemDesc = "ItemDesc";
    private final static String Email = "Email";
    private final static String LoginType = "LoginType";

    /*必填*/
    private String merchantID;
    private String respondType;
    private String timeStamp;
    private String version;
    private String merchantOrderNo;
    private String amt;
    private String itemDesc;
    private String email;
    private String loginType;


    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getRespondType() {
        return respondType;
    }

    public void setRespondType(String respondType) {
        this.respondType = respondType;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }


    public String toQueryString() {
        params.put(TradeInfo.MerchantID, getMerchantID());
        params.put(TradeInfo.RespondType, getRespondType());
        params.put(TradeInfo.TimeStamp, getTimeStamp());
        params.put(TradeInfo.Version, getVersion());
        params.put(TradeInfo.MerchantOrderNo, getMerchantOrderNo());
        params.put(TradeInfo.Amt, getAmt());
        params.put(TradeInfo.ItemDesc, getItemDesc());
        params.put(TradeInfo.Email, getEmail());
        params.put(TradeInfo.LoginType, getLoginType());

        return mapToQueryString(params);

    }

    private String mapToQueryString(Map<String, String> map) {
        List<String> collect = map.entrySet().stream()
                .map(x -> x.getKey() + "=" + x.getValue())
                .collect(Collectors.toList());
        return StringUtils.join(collect.toArray(),"&");
    }


//    private String langType;
//    private String tradeLimit;
//    private String expireDate;
//    private String returnURL;
//    private String notifyURL;
//    private String customerURL;
//    private String clientBackURL;
//    private String emailModify;
//    private String orderComment;


}
