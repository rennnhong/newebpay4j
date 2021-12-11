package idv.rennnhong.newebpay4j;

public enum BarCodeEnum {
    SEVEN("SEVEN", "7-11"),
    FAMILY("FAMILY", "全家"),
    OK("OK", "OK 超商"),
    HILIFE("HILIFE", "萊爾富");

    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    BarCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static BarCodeEnum valueOfCode(String code) {
        switch (code) {
            case "SEVEN":
                return SEVEN;
            case "FAMILY":
                return FAMILY;
            case "OK":
                return OK;
            case "HILIFE":
                return HILIFE;
            default:
                throw new IllegalArgumentException("unsupported payment type!");
        }
    }
}
