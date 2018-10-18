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

    public double getTotal() {
        return total - discount;
    }

    public Map<Rental, Integer> getRentals() {
        return Collections.unmodifiableMap(rentals);
    }

    public void addRental(Rental rental) {
        addRentals(rental, 1);
    }

    public void addRentals(Rental rental, Integer quantity) {
        Integer existingQuantity = rentals.get(rental);
        if (existingQuantity !=null)
            quantity += existingQuantity;
        rentals.put(rental, quantity);
    }

    public void updateRentals(Rental rental, Integer quantity) {
        rentals.put(rental, quantity);
    }

    public void removeRentals(Rental rental) {
        rentals.remove(rental);
    }

    public void checkIn() {
        checkInTime = LocalDateTime.now();
    }

    public void checkOut() {
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
