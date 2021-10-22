package machine;

public enum Actions {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");

    String value;

    Actions(String value) {
        this.value = value;
    }

    public static Actions findByValue(String val) {
        for (Actions value : values()) {
            if (val.equals(value.value)) {
                return value;
            }
        }
        return null;
    }
}
