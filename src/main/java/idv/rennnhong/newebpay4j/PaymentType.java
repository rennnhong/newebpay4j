package idv.rennnhong.newebpay4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum PaymentType {
    CREDIT("CREDIT", "信用卡"),
    WEBATM("WEBATM", "WebATM"),
    CVSCOM("CVSCOM", "超商物流"),
    BARCODE("BARCODE", "超商條碼繳費"),
    ALIPAY("ALIPAY", "支付寶(跨境支付)"),
    ESUNWALLET("ESUNWALLET", "玉山 Wallet"),
    P2G("P2G", "ezPay 電子錢包");

    private static Map<String, PaymentType> paymentTypeCaches = new HashMap<>();

    static {
        cacheEnums();
    }

    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    PaymentType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * @param code 藍新的支付方式代碼
     * @return
     */
    public static PaymentType valueOfCode(String code) {
        Optional<PaymentType> paymentTypeOptional = Optional.ofNullable(paymentTypeCaches.get(code));
        return paymentTypeOptional.orElseThrow(() -> new IllegalArgumentException("unsupported payment type!"));
    }

    private static void cacheEnums() {
        PaymentType[] values = values();
        for (PaymentType value : values) {
            paymentTypeCaches.put(value.code, value);
        }
    }
}
