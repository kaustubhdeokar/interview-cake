package currency;

public enum CurrencyType {

    USD("american dollar"),
    INR("indian rupees"),
    RUB("russian ruble");

    private final String name;

    CurrencyType(String name) {
        this.name = name;
    }
}
