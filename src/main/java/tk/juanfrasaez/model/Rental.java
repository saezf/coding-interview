package tk.juanfrasaez.model;

import java.time.temporal.ChronoUnit;

public enum Rental {
    HOURLY(5, ChronoUnit.HOURS),
    DAILY(20, ChronoUnit.DAYS),
    WEEKLY(60, ChronoUnit.WEEKS);

    public static final double FAMILY_RENTAL_DISCOUNT = .3;
    private final double price;
    private final ChronoUnit unit;

    Rental(double price, ChronoUnit unit) {
        this.price = price;
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public ChronoUnit getUnit() {
        return unit;
    }
}
