package idv.rennnhong.newebpay4j;

public enum AuthBankEnum {

    Esun("Esun", "玉山銀行"),
    Taishin("Taishin", "台新銀行"),
    CTBC("CTBC", "中國信託銀行"),
    NCCC("NCCC", "聯合信用卡中心 "),
    CathayBK("CathayBK", "國泰世華銀行 "),
    Citibank("Citibank", "花旗銀行 "),
    UBOT("UBOT", "聯邦銀行"),
    SKBank("SKBank", "新光銀行 "),
    Fubon("Fubon", "富邦銀行 "),
    FirstBank("FirstBank", "第一銀行");

    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    AuthBankEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static AuthBankEnum valueOfCode(String code) {
        switch (code) {
            case "Esun":
                return Esun;
            case "Taishin":
                return Taishin;
            case "CTBC":
                return CTBC;
            case "NCCC":
                return NCCC;
            case "CathayBK":
                return CathayBK;
            case "Citibank":
                return Citibank;
            case "UBOT":
                return UBOT;
            case "SKBank":
                return SKBank;
            case "Fubon":
                return Fubon;
            case "FirstBank":
                return FirstBank;
            default:
                throw new IllegalArgumentException("unsupported payment type!");
        }
    }
}
