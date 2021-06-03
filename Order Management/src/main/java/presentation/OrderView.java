package presentation;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

/**
 * Clasa care implementeaza interfata grafica pentru tabelul ordeer.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class OrderView extends JFrame {

    private final JTextField productQuantity;
    public JComboBox clients;
    public JComboBox products;
    private final JButton updateExistingThings;
    private final JButton placeOrder;

    /**
     * Implementarea ferestrei grafice.
     */
    public OrderView() {
        setTitle("Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 360, 400, 300);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        updateExistingThings = new JButton("Update clients / products");
        panel1.add(updateExistingThings);
        contentPane.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        products = new JComboBox();
        products.setToolTipText("Products");
        clients = new JComboBox();
        clients.setToolTipText("Clients");
        panel2.add(products);
        panel2.add(clients);
        productQuantity = new JTextField(10);
        productQuantity.setToolTipText("Quantity");
        panel2.add(productQuantity);
        contentPane.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        placeOrder = new JButton("Place order");
        panel3.add(placeOrder);
        contentPane.add(panel3);

        JLabel returnStatement = new JLabel("");
        contentPane.add(returnStatement);

    }

    /**
     * Adaugarea de ascultator pentru butonul de suprascriere a ComboBox-urilor cu clientii si produsele existenti in tabele.
     *
     * @param actionListener Ascultatorul.
     */
    public void addUpdateBtnListener(ActionListener actionListener) {
        this.updateExistingThings.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de plasare a unei comenzi.
     *
     * @param actionListener Ascultatorul.
     */
    public void addPlaceOrderBtnListener(ActionListener actionListener) {
        this.placeOrder.addActionListener(actionListener);
    }

    /**
     * Metoda care returneaza cantitatea produsului care se vrea sa fie cumparat de client.
     *
     * @return String cantitatea data de catre utilizator.
     */
    public String getQuantity() {
        return this.productQuantity.getText();
    }

}
