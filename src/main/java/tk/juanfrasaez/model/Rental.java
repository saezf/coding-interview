package tk.juanfrasaez.model;

public abstract class Rental {
    private final double price;

    public Rental(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
