package tk.juanfrasaez.model;

import java.time.temporal.ChronoUnit;

public class DailyRental extends Rental {
    public static final double PRICE = 20;
    public static final ChronoUnit UNIT = ChronoUnit.DAYS;

    public DailyRental() {
        super(PRICE, UNIT);
    }
}
