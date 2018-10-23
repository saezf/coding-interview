package tk.juanfrasaez.domain;

import tk.juanfrasaez.model.Rental;

import java.time.LocalDateTime;
import java.util.*;

public class Cart {
    private final Map<Rental, Integer> rentals = new HashMap<>();
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private double total;
    private double discount;

    /**
     * Returns the amount to be charged. Considering the total amount registered by rentals minus any applicable discount.
     *
     * @return the amount to be charged
     */
    public double getTotal() {
        return total - discount;
    }

    /**
     * Returns all rentals registered with their corresponding quantities.
     *
     * @return a {@link Map} of rentals and their quantities
     */
    public Map<Rental, Integer> getRentals() {
        return Collections.unmodifiableMap(rentals);
    }

    /**
     * Adds one rental.
     *
     * @param rental the rental to be added
     * @throws NullPointerException if the specified rental is null
     */
    public void addRental(Rental rental) {
        Objects.requireNonNull(rental);
        addRentals(rental, 1);
    }

    /**
     * Adds a rental with a given quantity. If the rental already exists, then the specified quantity is added to the
     * existing one.
     *
     * @param rental   the rental to be added
     * @param quantity the quantity of the rental
     * @throws NullPointerException if the specified rental or quantity is null
     */
    public void addRentals(Rental rental, Integer quantity) {
        Objects.requireNonNull(rental);
        Objects.requireNonNull(quantity);
        Integer existingQuantity = rentals.get(rental);
        if (existingQuantity !=null)
            quantity += existingQuantity;
        rentals.put(rental, quantity);
    }

    /**
     * Updates a rental with a given quantity. If the rental does not exist, it is added.
     *
     * @param rental   the rental to be updated
     * @param quantity the quantity of the rental
     * @throws NullPointerException if the specified rental or quantity is null
     */
    public void updateRentals(Rental rental, Integer quantity) {
        Objects.requireNonNull(rental);
        Objects.requireNonNull(quantity);
        rentals.put(rental, quantity);
    }

    /**
     * Removes an entire rental.
     *
     * @param rental the rental to be removed
     * @throws NullPointerException if the specified rental is null
     */
    public void removeRentals(Rental rental) {
        Objects.requireNonNull(rental);
        rentals.remove(rental);
    }

    /**
     * Starts the charging process, setting the check-in time.
     */
    public void checkIn() {
        checkInTime = LocalDateTime.now();
    }

    /**
     * Completes the charging process, setting the check-out time, total amount and discount.
     *
     * @throws IllegalStateException if it is invoked before {@link #checkIn()} method
     */
    public void checkOut() {
        if (checkInTime == null)
            throw new IllegalStateException();
        int numberOfRentals = 0;
        checkOutTime = LocalDateTime.now();
        for (Map.Entry<Rental, Integer> entry : rentals.entrySet()) {
            total += entry.getValue() * (checkInTime.until(checkOutTime, entry.getKey().getUnit()) + 1) * entry.getKey().getPrice();
            numberOfRentals += entry.getValue();
        }

        if (numberOfRentals <= 5 && numberOfRentals >= 3)
            discount = total * Rental.FAMILY_RENTAL_DISCOUNT;
    }

}
