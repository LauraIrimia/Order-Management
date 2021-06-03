package model;

/**
 * Clasa care reprezinta tabela client.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class Client {
    private int id;
    private String name;
    private String address;

    public Client() {

    }

    public Client(int id, String name, String address) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
    }

    public String toString() {
        return "Client id: " + this.getId() + ", name: " + this.getName() + ", address: " + this.getAddress();
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
