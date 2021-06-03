package model;

/**
 * Clasa care reprezinta tabela ordeer.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class Ordeer {
    private int id = 0;
    private String productName;
    private String clientName;
    private int quantity;
    private double price;

    public Ordeer() {

    }

    public Ordeer(int id, String product, String client, int quantity, double price) {
        this.setId(id);
        this.setProductName(product);
        this.setClientName(client);
        this.setQuantity(quantity);
        this.setPrice(price);
    }

    public String toString() {
        return "Order id: " + this.getId() + ", client name: " + this.getClientName() + ", product name: "
                + this.getProductName() + ", quantity: " + this.getQuantity() + ", price: " + this.getPrice();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
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
