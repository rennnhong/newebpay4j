package idv.rennnhong.neweb.notify;

import idv.rennnhong.neweb.PaymentType;

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
        public Credit() {
            super(PaymentType.CREDIT);
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