package tk.juanfrasaez.domain;

import org.junit.Before;
import org.junit.Test;
import tk.juanfrasaez.model.DailyRental;
import tk.juanfrasaez.model.HourlyRental;
import tk.juanfrasaez.model.Rental;
import tk.juanfrasaez.model.WeeklyRental;

import static org.junit.Assert.assertEquals;

public class CartTest {
    private Cart cart;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
    }

    @Test
    public void shouldCalculateCorrectAmountByHour() {
        cart.addRental(new HourlyRental());
        cart.checkIn();
        cart.checkOut();
        assertEquals(HourlyRental.PRICE, cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountByDay() {
        cart.addRental(new DailyRental());
        cart.checkIn();
        cart.checkOut();
        assertEquals(DailyRental.PRICE, cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountByWeek() {
        cart.addRental(new WeeklyRental());
        cart.checkIn();
        cart.checkOut();
        assertEquals(WeeklyRental.PRICE, cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountWithTwoRentals() {
        cart.addRental(new HourlyRental());
        cart.addRental(new DailyRental());
        cart.checkIn();
        cart.checkOut();
        assertEquals(HourlyRental.PRICE + DailyRental.PRICE, cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountWithOneOfEach() {
        cart.addRental(new HourlyRental());
        cart.addRental(new DailyRental());
        cart.addRental(new WeeklyRental());
        cart.checkIn();
        cart.checkOut();
        assertEquals((HourlyRental.PRICE + DailyRental.PRICE + WeeklyRental.PRICE) *
                (1 - Rental.FAMILY_RENTAL_DISCOUNT), cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountWithFourRentals() {
        cart.addRentals(new HourlyRental(), 4);
        cart.checkIn();
        cart.checkOut();
        assertEquals((4 * HourlyRental.PRICE) * (1 - Rental.FAMILY_RENTAL_DISCOUNT), cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountWithFiveRentals() {
        cart.addRentals(new DailyRental(), 5);
        cart.checkIn();
        cart.checkOut();
        assertEquals((5 * DailyRental.PRICE) * (1 - Rental.FAMILY_RENTAL_DISCOUNT), cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountWithSixRentals() {
        cart.addRentals(new WeeklyRental(), 6);
        cart.checkIn();
        cart.checkOut();
        assertEquals(6 * WeeklyRental.PRICE, cart.getTotal(), 0.001);
    }
}