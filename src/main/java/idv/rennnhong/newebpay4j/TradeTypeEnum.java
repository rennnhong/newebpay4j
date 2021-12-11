package idv.rennnhong.newebpay4j;

public enum TradeTypeEnum {

    Payment_For_Pickup(1, "取貨付款"),
    No_Payment_For_Pickup(3, "取貨不付款");

    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    TradeTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static TradeTypeEnum valueOfCode(int code) {
        switch (code) {
            case 1:
                return Payment_For_Pickup;
            case 3:
                return No_Payment_For_Pickup;
            default:
                throw new IllegalArgumentException("unsupported payment type!");
        }
    }
}
