package tk.juanfrasaez.model;

import java.time.temporal.ChronoUnit;

public abstract class Rental {
    public static final double FAMILY_RENTAL_DISCOUNT = .3;
    private final double price;
    private final ChronoUnit unit;

    public Rental(double price, ChronoUnit unit) {
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
