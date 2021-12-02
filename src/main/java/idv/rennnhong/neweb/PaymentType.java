package idv.rennnhong.neweb;

public enum PaymentType {
    CREDIT("CREDIT", "信用卡"),
    WEBATM("WEBATM", "WebATM");


    private String code;
    private String description;


    PaymentType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static PaymentType valueOfCode(String code) {
        switch (code) {
            case "CREDIT":
                return CREDIT;
            case "WEBATM":
                return WEBATM;
            default:
                throw new IllegalArgumentException("unsupported payment type!");
        }

    }
}
