package idv.rennnhong.newebpay4j;

public enum StoreTypeEnum {
    SEVEN_ELEVEN("1", "7-11 統一超商"),
    FAMILY_MART("2", "全家便利商店"),
    OK("3", "OK 便利商店"),
    HI_LIFE("4", "萊爾富便利商店");

    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    StoreTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static StoreTypeEnum valueOfCode(Integer code) {
        switch (code) {
            case 1:
                return SEVEN_ELEVEN;
            case 2:
                return FAMILY_MART;
            case 3:
                return OK;
            case 4:
                return HI_LIFE;
            default:
                throw new IllegalArgumentException("unsupported payment type!");
        }
    }
}
