package idv.rennnhong.newebpay4j.response;

import idv.rennnhong.newebpay4j.PaymentType;

public abstract class TradeInfoResult {

    private final PaymentType paymentType;

    private String merchantID;
    private Integer amt;
    private String tradeNo;
    private String merchantOrderNo;
    private String respondType;
    private String payTime;
    private String ip;
    private String escrowBank;

    public TradeInfoResult(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public <T extends TradeInfoResult> T toConcreteType(Class<T> clz) {
        return clz.cast(this);
    }

    public String getMerchantID() {
        return merchantID;
    }

    public TradeInfoResult setMerchantID(String merchantID) {
        this.merchantID = merchantID;
        return this;
    }

    public Integer getAmt() {
        return amt;
    }

    public TradeInfoResult setAmt(Integer amt) {
        this.amt = amt;
        return this;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public TradeInfoResult setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public TradeInfoResult setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
        return this;
    }

    public String getRespondType() {
        return respondType;
    }

    public TradeInfoResult setRespondType(String respondType) {
        this.respondType = respondType;
        return this;
    }

    public String getPayTime() {
        return payTime;
    }

    public TradeInfoResult setPayTime(String payTime) {
        this.payTime = payTime;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public TradeInfoResult setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getEscrowBank() {
        return escrowBank;
    }

    public TradeInfoResult setEscrowBank(String escrowBank) {
        this.escrowBank = escrowBank;
        return this;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * CVSCOM 超商物流回傳參數
     */
    public static class CVSCOM extends TradeInfoResult {
        private String storeCode;
        private String storeName;
        private String storeType;
        private String storeAddr;
        private int tradeType;
        private String cvscomName;
        private String cvscomPhone;
        private String lgsNo;

        public CVSCOM() {
            super(PaymentType.CVSCOM);
        }

        public String getStoreCode() {
            return storeCode;
        }

        public CVSCOM setStoreCode(String storeCode) {
            this.storeCode = storeCode;
            return this;
        }

        public String getStoreName() {
            return storeName;
        }

        public CVSCOM setStoreName(String storeName) {
            this.storeName = storeName;
            return this;
        }

        public String getStoreType() {
            return storeType;
        }

        public CVSCOM setStoreType(String storeType) {
            this.storeType = storeType;
            return this;
        }

        public String getStoreAddr() {
            return storeAddr;
        }

        public CVSCOM setStoreAddr(String storeAddr) {
            this.storeAddr = storeAddr;
            return this;
        }

        public int getTradeType() {
            return tradeType;
        }

        public CVSCOM setTradeType(int tradeType) {
            this.tradeType = tradeType;
            return this;
        }

        public String getCvscomName() {
            return cvscomName;
        }

        public CVSCOM setCvscomName(String cvscomName) {
            this.cvscomName = cvscomName;
            return this;
        }

        public String getCvscomPhone() {
            return cvscomPhone;
        }

        public CVSCOM setCvscomPhone(String cvscomPhone) {
            this.cvscomPhone = cvscomPhone;
            return this;
        }

        public String getLgsNo() {
            return lgsNo;
        }

        public CVSCOM setLgsNo(String lgsNo) {
            this.lgsNo = lgsNo;
            return this;
        }

        @Override
        public String toString() {
            return "CVSCOM{" +
                    "storeCode='" + storeCode + '\'' +
                    ", storeName='" + storeName + '\'' +
                    ", storeType='" + storeType + '\'' +
                    ", storeAddr='" + storeAddr + '\'' +
                    ", tradeType=" + tradeType +
                    ", cvscomName='" + cvscomName + '\'' +
                    ", cvscomPhone='" + cvscomPhone + '\'' +
                    ", lgsNo='" + lgsNo + '\'' +
                    '}' + super.toString();
        }
    }
    /**
     * 超商條碼繳費
     */
    public static class BARCODE extends TradeInfoResult {
        private String barcode_1;
        private String barcode_2;
        private String barcode_3;
        private String payStore;

        public BARCODE() {
            super(PaymentType.BARCODE);
        }

        public String getBarcode_1() {
            return barcode_1;
        }

        public BARCODE setBarcode_1(String barcode_1) {
            barcode_1 = barcode_1;
            return this;
        }

        public String getBarcode_2() {
            return barcode_2;
        }

        public BARCODE setBarcode_2(String barcode_2) {
            barcode_2 = barcode_2;
            return this;
        }

        public String getBarcode_3() {
            return barcode_3;
        }

        public BARCODE setBarcode_3(String barcode_3) {
            barcode_3 = barcode_3;
            return this;
        }

        public String getPayStore() {
            return payStore;
        }

        public BARCODE setPayStore(String payStore) {
            this.payStore = payStore;
            return this;
        }

        @Override
        public String toString() {
            return "BARCODE{" +
                    "Barcode_1='" + barcode_1 + '\'' +
                    ", Barcode_2='" + barcode_2 + '\'' +
                    ", Barcode_3='" + barcode_3 + '\'' +
                    ", payStore='" + payStore + '\'' +
                    '}' + super.toString();
        }
    }
    /**
     *
     */
    public static class AliPay extends TradeInfoResult {
        private String channelID;
        private String channelNo;

        public AliPay() {
            super(PaymentType.ALIPAY);
        }

        public String getChannelID() {
            return channelID;
        }

        public AliPay setChannelID(String channelID) {
            this.channelID = channelID;
            return this;
        }

        public String getChannelNo() {
            return channelNo;
        }

        public AliPay setChannelNo(String channelNo) {
            this.channelNo = channelNo;
            return this;
        }

        @Override
        public String toString() {
            return "AliPay{" +
                    "channelID='" + channelID + '\'' +
                    ", channelNo='" + channelNo + '\'' +
                    '}' + super.toString();
        }
    }

    /**
     * WEBATM、ATM 繳費回傳參數
     */
    public static class ATM extends TradeInfoResult {
        private String payBankCode;
        private String payerAccount5Code;

        public ATM() {
            super(PaymentType.WEBATM);
        }

        public String getPayBankCode() {
            return payBankCode;
        }

        public ATM setPayBankCode(String payBankCode) {
            this.payBankCode = payBankCode;
            return this;
        }

        public String getPayerAccount5Code() {
            return payerAccount5Code;
        }

        public ATM setPayerAccount5Code(String payerAccount5Code) {
            this.payerAccount5Code = payerAccount5Code;
            return this;
        }

        @Override
        public String toString() {
            return "ATM{" +
                    "payBankCode='" + payBankCode + '\'' +
                    ", payerAccount5Code='" + payerAccount5Code + '\'' +
                    "} " + super.toString();
        }
    }

    /**
     * 信用卡支付回傳參數(一次付清、Google Pay、Samaung Pay、國民旅遊卡、銀聯)
     */
    public static class Credit extends TradeInfoResult {
        private String authBank;
        private String respondCode;
        private String auth;
        private String card6No;
        private String card4No;
        private String eci;
        private String paymentMethod;
        private int inst;
        private int instFirst;
        private int instEach;
        private int tokenUseStatus;
        private int redAmt;
        private int dccCurrencyCode;
        private float dccAmt;
        private float dccRate;
        private float dccMarkup;
        private String dccCurrency;

        public Credit() {
            super(PaymentType.CREDIT);
        }

        public String getAuthBank() {
            return authBank;
        }

        public Credit setAuthBank(String authBank) {
            this.authBank = authBank;
            return this;
        }

        public String getRespondCode() {
            return respondCode;
        }

        public Credit setRespondCode(String respondCode) {
            this.respondCode = respondCode;
            return this;
        }

        public String getAuth() {
            return auth;
        }

        public Credit setAuth(String auth) {
            this.auth = auth;
            return this;
        }

        public String getCard6No() {
            return card6No;
        }

        public Credit setCard6No(String card6No) {
            this.card6No = card6No;
            return this;
        }

        public String getCard4No() {
            return card4No;
        }

        public Credit setCard4No(String card4No) {
            this.card4No = card4No;
            return this;
        }

        public String getEci() {
            return eci;
        }

        public Credit setEci(String eci) {
            this.eci = eci;
            return this;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public Credit setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public int getInst() {
            return inst;
        }

        public Credit setInst(int inst) {
            this.inst = inst;
            return this;
        }

        public int getInstFirst() {
            return instFirst;
        }

        public Credit setInstFirst(int instFirst) {
            this.instFirst = instFirst;
            return this;
        }

        public int getInstEach() {
            return instEach;
        }

        public Credit setInstEach(int instEach) {
            this.instEach = instEach;
            return this;
        }

        public int getTokenUseStatus() {
            return tokenUseStatus;
        }

        public Credit setTokenUseStatus(int tokenUseStatus) {
            this.tokenUseStatus = tokenUseStatus;
            return this;
        }

        public int getRedAmt() {
            return redAmt;
        }

        public Credit setRedAmt(int redAmt) {
            this.redAmt = redAmt;
            return this;
        }

        public int getDccCurrencyCode() {
            return dccCurrencyCode;
        }

        public Credit setDccCurrencyCode(int dccCurrencyCode) {
            this.dccCurrencyCode = dccCurrencyCode;
            return this;
        }

        public float getDccAmt() {
            return dccAmt;
        }

        public Credit setDccAmt(float dccAmt) {
            this.dccAmt = dccAmt;
            return this;
        }

        public float getDccRate() {
            return dccRate;
        }

        public Credit setDccRate(float dccRate) {
            this.dccRate = dccRate;
            return this;
        }

        public float getDccMarkup() {
            return dccMarkup;
        }

        public Credit setDccMarkup(float dccMarkup) {
            this.dccMarkup = dccMarkup;
            return this;
        }

        public String getDccCurrency() {
            return dccCurrency;
        }


        public Credit setDccCurrency(String dccCurrency) {
            this.dccCurrency = dccCurrency;
            return this;
        }

        @Override
        public String toString() {
            return "Credit {authBank='" + authBank + '\'' +
                    ", respondCode='" + respondCode + '\'' +
                    ", auth='" + auth + '\'' +
                    ", card6No='" + card6No + '\'' +
                    ", card4No='" + card4No + '\'' +
                    ", eci='" + eci + '\'' +
                    ", paymentMethod='" + paymentMethod + '\'' +
                    ", inst=" + inst +
                    ", instFirst=" + instFirst +
                    ", instEach=" + instEach +
                    ", tokenUseStatus=" + tokenUseStatus +
                    ", redAmt=" + redAmt +
                    ", dccCurrency_Code=" + dccCurrencyCode +
                    ", dccAmt=" + dccAmt +
                    ", dccRate=" + dccRate +
                    ", dccMarkup=" + dccMarkup +
                    ", dccCurrency=" + dccCurrency +
                    "}" + super.toString();
        }
    }

    @Override
    public String toString() {
        return "TradeInfoResult{" +
                "paymentType=" + paymentType +
                ", merchantID='" + merchantID + '\'' +
                ", amt='" + amt + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", merchantOrderNo='" + merchantOrderNo + '\'' +
                ", respondType='" + respondType + '\'' +
                ", payTime='" + payTime + '\'' +
                ", ip='" + ip + '\'' +
                ", escrowBank='" + escrowBank + '\'' +
                '}';
    }
}
