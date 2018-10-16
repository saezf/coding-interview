package tk.juanfrasaez.model;

import java.time.temporal.ChronoUnit;

public class WeeklyRental extends Rental {
    public static final double PRICE = 60;
    public static final ChronoUnit UNIT = ChronoUnit.WEEKS;

    public WeeklyRental() {
        super(PRICE, UNIT);
    }
}
