package model;

/**
 * Clasa care reprezinta tabela product.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product() {

    }

    public Product(int id, String name, int quantity, double price) {
        this.setId(id);
        this.setName(name);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    public String toString() {
        return "Product id: " + this.getId() + ", name: " + this.getName() + ", quantity: " + this.getQuantity()
                + ", price: " + this.getPrice();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
