package presentation;

import bll.*;
import bll.validators.Validator;
import model.*;
import start.ReflectionTechnique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa care se ocupa cu legarea componentelor implementate.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class Controller {
    private static int id = 0;
    private final ClientView clientView;
    private final ProductView productView;
    private final OrderView orderView;
    private final ClientBLL clientBLL;
    private final ProductBLL productBLL;
    private final OrderBLL orderBLL;

    /**
     * Constructorul clasei care contine instantierea parametrilor si implementarea metodelor ascultatoare din cele 3 interfete.
     *
     * @param cView Obiectul responsabil de interfata tabelei client.
     * @param pView Obiectul responsabil de interfata tabelei product.
     * @param oView Obiectul responsabil de interfata tabelei ordeer.
     */
    public Controller(ClientView cView, ProductView pView, OrderView oView) {
        this.clientView = cView;
        this.productView = pView;
        this.orderView = oView;
        clientBLL = new ClientBLL();
        productBLL = new ProductBLL();
        orderBLL = new OrderBLL();
        clientView.addInsertBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de adaugare a unui client in tabela.
             * @param e Apasarea butonului de insert.
             */
            public void actionPerformed(ActionEvent e) {
                int id;
                String name, address;
                id = Integer.parseInt(clientView.getIdInsert());
                name = clientView.getNameInsert();
                address = clientView.getAddressInsert();
                Client c = new Client(id, name, address);
                clientBLL.insertClient(c);
            }
        });
        clientView.addUpdateNameBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de schimbare a numelui a unui client din tabela.
             * @param e Apasarea butonului de update a numelui.
             */
            public void actionPerformed(ActionEvent e) {
                int id;
                String name;
                id = Integer.parseInt(clientView.getIdUpdateName());
                name = clientView.getNameUpdateName();
                clientBLL.updateName(id, name);
            }
        });
        clientView.addUpdateAddressBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de schimbare a adresei a unui client din tabela.
             * @param e Apasarea butonului de update a adresei.
             */
            public void actionPerformed(ActionEvent e) {
                int id;
                String address;
                id = Integer.parseInt(clientView.getIdUpdateAddress());
                address = clientView.getAddressUpdateAddress();
                clientBLL.updateAddress(id, address);
            }
        });
        clientView.addDeleteBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de stergere a unui client din tabela.
             * @param e Apasarea butonului de delete.
             */
            public void actionPerformed(ActionEvent e) {
                int id;
                id = Integer.parseInt(clientView.getIdDelete());
                clientBLL.deleteClient(id);
            }
        });
        clientView.addFindByIdBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de gasire dupa id a unui client din tabela.
             * @param e Apasarea butonului de find dupa id.
             */
            public void actionPerformed(ActionEvent e) {
                int id;
                id = Integer.parseInt(clientView.getIdFindById());
                try {
                    Client c = clientBLL.findClientById(id);
                    clientView.setClientById(c.toString());
                } catch (NoSuchElementException ex) {
                    clientView.setClientById(ex.getMessage());
                }
            }
        });
        clientView.addFindAllBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de extragere a tuturor clientilor din tabela.
             * @param e Apasarea butonului de find all.
             */
            public void actionPerformed(ActionEvent e) {
                List<Client> listC = clientBLL.findAllClients();
                String[] column;
                String[][] data;
                column = ReflectionTechnique.retrieveFieldProperties(listC.get(0));
                data = new String[listC.size()][column.length];
                int i = 0;
                for (Client c : listC) {
                    data[i] = ReflectionTechnique.retrieveValueProperties(c);
                    i++;
                }
                JFrame tabelClients = new JFrame("Clients table");
                JTable jt = new JTable(data, column);
                JScrollPane sp = new JScrollPane(jt);
                tabelClients.add(sp);
                tabelClients.setBounds(500, 400, 300, 200);
                tabelClients.setVisible(true);
            }
        });
        //////////////////////////////////////////////////////////////////////////////
        productView.addInsertBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de adaugare a unui produs in tabela.
             * @param e Apasarea butonului de insert.
             */
            public void actionPerformed(ActionEvent e) {
                int id, quantity;
                String name;
                double price;
                id = Integer.parseInt(productView.getIdInsert());
                quantity = Integer.parseInt(productView.getQuantityInsert());
                name = productView.getNameInsert();
                price = Double.parseDouble(productView.getPriceInsert());
                Product p = new Product(id, name, quantity, price);
                try {
                    for (Validator<Product> v : productBLL.getValidators()) {
                        v.validate(p);
                    }
                    productBLL.insertProduct(p);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(productView, ex.getMessage(), "Validate Error", 0);
                }
            }
        });
        productView.addUpdateNameBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de schimbare a numelui a unui produs din tabela.
             * @param e Apasarea butonului de update a numelui.
             */
            public void actionPerformed(ActionEvent e) {
                int id;
                String name;
                id = Integer.parseInt(productView.getIdUpdateName());
                name = productView.getNameUpdateName();
                productBLL.updateName(id, name);
            }
        });
        productView.addUpdateQuantityBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de schimbare a cantitatii a unui produs din tabela.
             * @param e Apasarea butonului de update a cantitatii.
             */
            public void actionPerformed(ActionEvent e) {
                int id;
                int quantity;
                id = Integer.parseInt(productView.getIdUpdateQuantity());
                quantity = Integer.parseInt(productView.getQuantityUpdateQuantity());
                productBLL.updateQuantity(id, quantity);
            }
        });
        productView.addUpdatePriceBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de schimbare a pretului a unui produs din tabela.
             * @param e Apasarea butonului de update a pretului.
             */
            public void actionPerformed(ActionEvent e) {
                int id;
                double price;
                id = Integer.parseInt(productView.getIdUpdatePrice());
                price = Double.parseDouble(productView.getPriceUpdatePrice());
                productBLL.updatePrice(id, price);
            }
        });
        productView.addDeleteBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de stergere a unui produs din tabela.
             * @param e Apasarea butonului de delete.
             */
            public void actionPerformed(ActionEvent e) {
                int id;
                id = Integer.parseInt(productView.getIdDelete());
                productBLL.deleteProduct(id);
            }
        });
        productView.addFindByIdBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de gasire dupa id a unui produs din tabela.
             * @param e Apasarea butonului de find dupa id.
             */
            public void actionPerformed(ActionEvent e) {
                int id;
                id = Integer.parseInt(productView.getIdFindById());
                try {
                    Product p = productBLL.findProductById(id);
                    productView.setProductById(p.toString());
                } catch (NoSuchElementException ex) {
                    productView.setProductById(ex.getMessage());
                }
            }
        });
        productView.addFindAllBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de extragere a tuturor produselor din tabela.
             * @param e Apasarea butonului de find all.
             */
            public void actionPerformed(ActionEvent e) {
                List<Product> listP = productBLL.findAllProducts();
                String[] column;
                String[][] data;
                column = ReflectionTechnique.retrieveFieldProperties(listP.get(0));
                data = new String[listP.size()][column.length];
                int i = 0;
                for (Product p : listP) {
                    data[i] = ReflectionTechnique.retrieveValueProperties(p);
                    i++;
                }
                JFrame tabelClients = new JFrame("Products table");
                JTable jt = new JTable(data, column);
                JScrollPane sp = new JScrollPane(jt);
                tabelClients.add(sp);
                tabelClients.setBounds(800, 400, 300, 200);
                tabelClients.setVisible(true);
            }
        });
        /////////////////////////////////////////////////////////////////////////
        orderView.addUpdateBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de suprascriere a listelor de clienti si produse existenti.
             * @param e Apasarea butonului de update produse si clienti.
             */
            public void actionPerformed(ActionEvent e) {
                List<Product> listP = productBLL.findAllProducts();
                List<Client> listC = clientBLL.findAllClients();
                for (Product p : listP) {
                    orderView.products.addItem(p.getName());
                }
                for (Client c : listC) {
                    orderView.clients.addItem(c.getName());
                }
            }
        });
        orderView.addPlaceOrderBtnListener(new ActionListener() {
            /**
             * Implementarea metodei ascultatoare de plasare a unei comenzi.
             * @param e Apasarea butonului de place order.
             */
            public void actionPerformed(ActionEvent e) {
                List<Product> listP = productBLL.findAllProducts();
                int q = 0, qView, idPr = 0;
                double pr = 0;
                qView = Integer.parseInt(orderView.getQuantity());
                String product = (String) orderView.products.getSelectedItem();
                for (Product p : listP) {
                    if (p.getName().equals(product)) {
                        q = p.getQuantity();
                        pr = p.getPrice();
                        idPr = p.getId();
                    }
                }
                if (qView > q) {
                    JOptionPane.showMessageDialog(orderView, "Only " + q + " left in stock!", "Stock Error", 0);
                } else {
                    id++;
                    Ordeer order = new Ordeer(id, (String) orderView.products.getSelectedItem(), (String) orderView.clients.getSelectedItem(), qView, qView * pr);
                    orderBLL.insertOrder(order);
                    JOptionPane.showMessageDialog(orderView, order.toString(), "Order placed", 1);
                    createBill(order.toString(), id);
                    productBLL.updateQuantity(idPr, q - qView);
                }
            }
        });
    }

    /**
     * Metoda responsabila cu scrierea fiecarei comenzi intr-un fisier diferit.
     *
     * @param orderBill Comanda care trebuie scrisa in fisier.
     * @param id        Numarul care trebuie adaugat la numele fisierului txt.
     */
    public void createBill(String orderBill, int id) {
        try {
            File myFile = new File("src/main/resources/bill" + id + ".txt");
            FileWriter myWriter = new FileWriter(myFile);
            myWriter.write(orderBill);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
