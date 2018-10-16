package tk.juanfrasaez.model;

import java.time.temporal.ChronoUnit;

public class HourlyRental extends Rental {
    public static final double PRICE = 5;
    public static final ChronoUnit UNIT = ChronoUnit.HOURS;

    public HourlyRental() {
        super(PRICE, UNIT);
    }
}
