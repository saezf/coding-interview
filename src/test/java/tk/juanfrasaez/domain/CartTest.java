package tk.juanfrasaez.domain;

import org.junit.Before;
import org.junit.Test;
import tk.juanfrasaez.model.Rental;

import static org.junit.Assert.assertEquals;

public class CartTest {
    private Cart cart;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
    }

    @Test
    public void shouldCalculateCorrectAmountByHour() {
        cart.addRental(Rental.HOURLY);
        cart.checkIn();
        cart.checkOut();
        assertEquals(Rental.HOURLY.getPrice(), cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountByDay() {
        cart.addRental(Rental.DAILY);
        cart.checkIn();
        cart.checkOut();
        assertEquals(Rental.DAILY.getPrice(), cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountByWeek() {
        cart.addRental(Rental.WEEKLY);
        cart.checkIn();
        cart.checkOut();
        assertEquals(Rental.WEEKLY.getPrice(), cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountWithTwoRentals() {
        cart.addRental(Rental.HOURLY);
        cart.addRental(Rental.DAILY);
        cart.checkIn();
        cart.checkOut();
        assertEquals(Rental.HOURLY.getPrice() + Rental.DAILY.getPrice(), cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountWithOneOfEach() {
        cart.addRental(Rental.HOURLY);
        cart.addRental(Rental.DAILY);
        cart.addRental(Rental.WEEKLY);
        cart.checkIn();
        cart.checkOut();
        assertEquals((Rental.HOURLY.getPrice() + Rental.DAILY.getPrice() + Rental.WEEKLY.getPrice()) *
                (1 - Rental.FAMILY_RENTAL_DISCOUNT), cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountWithFourRentals() {
        cart.addRentals(Rental.HOURLY, 4);
        cart.checkIn();
        cart.checkOut();
        assertEquals((4 * Rental.HOURLY.getPrice()) * (1 - Rental.FAMILY_RENTAL_DISCOUNT), cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountWithFiveRentals() {
        cart.addRentals(Rental.DAILY, 5);
        cart.checkIn();
        cart.checkOut();
        assertEquals((5 * Rental.DAILY.getPrice()) * (1 - Rental.FAMILY_RENTAL_DISCOUNT), cart.getTotal(), 0.001);
    }

    @Test
    public void shouldCalculateCorrectAmountWithSixRentals() {
        cart.addRentals(Rental.WEEKLY, 6);
        cart.checkIn();
        cart.checkOut();
        assertEquals(6 * Rental.WEEKLY.getPrice(), cart.getTotal(), 0.001);
    }
}