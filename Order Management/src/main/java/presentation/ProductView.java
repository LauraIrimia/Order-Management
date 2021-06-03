package presentation;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

/**
 * Clasa care implementeaza interfata grafica pentru tabelul product.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class ProductView extends JFrame {

    private final JTextField idInsert;
    private final JTextField nameInsert;
    private final JTextField quantityInsert;
    private final JTextField priceInsert;
    private final JTextField idUpdateName;
    private final JTextField nameUpdateName;
    private final JTextField idUpdateQuantity;
    private final JTextField quantityUpdateQuantity;
    private final JTextField idUpdatePrice;
    private final JTextField priceUpdatePrice;
    private final JTextField idDelete;
    private final JTextField idFindById;
    private final JLabel productById;
    private final JButton insert;
    private final JButton updateName;
    private final JButton updateQuantity;
    private final JButton updatePrice;
    private final JButton delete;
    private final JButton findById;
    private final JButton findAll;

    /**
     * Implementarea ferestrei grafice.
     */
    public ProductView() {
        setTitle("Product");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 50, 600, 330);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        insert = new JButton("Insert");
        panel1.add(insert);
        JLabel lblNewLabel1 = new JLabel("new product ");
        panel1.add(lblNewLabel1);
        idInsert = new JTextField(10);
        idInsert.setToolTipText("Id");
        panel1.add(idInsert);
        nameInsert = new JTextField(10);
        nameInsert.setToolTipText("Name");
        panel1.add(nameInsert);
        quantityInsert = new JTextField(10);
        quantityInsert.setToolTipText("Quantity");
        panel1.add(quantityInsert);
        priceInsert = new JTextField(10);
        priceInsert.setToolTipText("Price");
        panel1.add(priceInsert);
        contentPane.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        updateName = new JButton("Update");
        panel2.add(updateName);
        JLabel lblNewLabel2 = new JLabel("product name ");
        panel2.add(lblNewLabel2);
        idUpdateName = new JTextField(10);
        idUpdateName.setToolTipText("Id");
        panel2.add(idUpdateName);
        nameUpdateName = new JTextField(10);
        nameUpdateName.setToolTipText("Name");
        panel2.add(nameUpdateName);
        contentPane.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        updateQuantity = new JButton("Update");
        panel3.add(updateQuantity);
        JLabel lblNewLabel3 = new JLabel("product quantity ");
        panel3.add(lblNewLabel3);
        idUpdateQuantity = new JTextField(10);
        idUpdateQuantity.setToolTipText("Id");
        panel3.add(idUpdateQuantity);
        quantityUpdateQuantity = new JTextField(10);
        quantityUpdateQuantity.setToolTipText("Quantity");
        panel3.add(quantityUpdateQuantity);
        contentPane.add(panel3);

        JPanel panel31 = new JPanel();
        panel31.setLayout(new FlowLayout());
        updatePrice = new JButton("Update");
        panel31.add(updatePrice);
        JLabel lblNewLabel31 = new JLabel("product price ");
        panel31.add(lblNewLabel31);
        idUpdatePrice = new JTextField(10);
        idUpdatePrice.setToolTipText("Id");
        panel31.add(idUpdatePrice);
        priceUpdatePrice = new JTextField(10);
        priceUpdatePrice.setToolTipText("Price");
        panel31.add(priceUpdatePrice);
        contentPane.add(panel31);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        delete = new JButton("Delete");
        panel4.add(delete);
        JLabel lblNewLabel4 = new JLabel("product ");
        panel4.add(lblNewLabel4);
        idDelete = new JTextField(10);
        idDelete.setToolTipText("Id");
        panel4.add(idDelete);
        contentPane.add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());
        findById = new JButton("Find");
        panel5.add(findById);
        JLabel lblNewLabel5 = new JLabel("product with id ");
        panel5.add(lblNewLabel5);
        idFindById = new JTextField(10);
        idFindById.setToolTipText("Id");
        panel5.add(idFindById);
        contentPane.add(panel5);

        JPanel panel51 = new JPanel();
        panel51.setLayout(new FlowLayout());
        productById = new JLabel("");
        panel51.add(productById);
        contentPane.add(panel51);

        JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout());
        findAll = new JButton("Find");
        panel6.add(findAll);
        JLabel lblNewLabel6 = new JLabel("all products ");
        panel6.add(lblNewLabel6);
        contentPane.add(panel6);

    }

    /**
     * Adaugarea de ascultator pentru butonul de inserare a unui produs in tabela.
     *
     * @param actionListener Ascultatorul.
     */
    public void addInsertBtnListener(ActionListener actionListener) {
        this.insert.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de modificare a namelui unui produs din tabela.
     *
     * @param actionListener Ascultatorul.
     */
    public void addUpdateNameBtnListener(ActionListener actionListener) {
        this.updateName.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de modificare a cantitaii unui produs din tabela.
     *
     * @param actionListener Ascultatorul.
     */
    public void addUpdateQuantityBtnListener(ActionListener actionListener) {
        this.updateQuantity.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de modificare a pretului unui produs din tabela.
     *
     * @param actionListener Ascultatorul.
     */
    public void addUpdatePriceBtnListener(ActionListener actionListener) {
        this.updatePrice.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de stergere a unui produs din tabela.
     *
     * @param actionListener Ascultatorul.
     */
    public void addDeleteBtnListener(ActionListener actionListener) {
        this.delete.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de cautare a unui produs din tabela dupa id.
     *
     * @param actionListener Ascultatorul.
     */
    public void addFindByIdBtnListener(ActionListener actionListener) {
        this.findById.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de afisare a tuturor produselor din tabela sub forma de JTabel.
     *
     * @param actionListener Ascultatorul.
     */
    public void addFindAllBtnListener(ActionListener actionListener) {
        this.findAll.addActionListener(actionListener);
    }

    /**
     * Metoda care returneaza id-ul produsului care se vrea sa fie inserat de utilizator.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdInsert() {
        return this.idInsert.getText();
    }

    /**
     * Metoda care returneaza numele produsului care se vrea sa fie inserat de utilizator.
     *
     * @return String numele dat de catre utilizator.
     */
    public String getNameInsert() {
        return this.nameInsert.getText();
    }

    /**
     * Metoda care returneaza cantitatea produsului care se vrea sa fie inserat de utilizator.
     *
     * @return String cantitatea data de catre utilizator.
     */
    public String getQuantityInsert() {
        return this.quantityInsert.getText();
    }

    /**
     * Metoda care returneaza pretul produsului care se vrea sa fie inserat de utilizator.
     *
     * @return String pretul dat de catre utilizator.
     */
    public String getPriceInsert() {
        return this.priceInsert.getText();
    }

    /**
     * Metoda care returneaza id-ul produsului caruia se doreste schimbarea numelui.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdUpdateName() {
        return this.idUpdateName.getText();
    }

    /**
     * Metoda care returneaza numele cu care utilizator vrea sa schimbe numele produsului existent.
     *
     * @return String numele dat de catre utilizator.
     */
    public String getNameUpdateName() {
        return this.nameUpdateName.getText();
    }

    /**
     * Metoda care returneaza id-ul produsului caruia se doreste schimbarea cantitatii.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdUpdateQuantity() {
        return this.idUpdateQuantity.getText();
    }

    /**
     * Metoda care returneaza cantitatea cu care utilizator vrea sa schimbe cantitatea produsului existent.
     *
     * @return String cantitatea data de catre utilizator.
     */
    public String getQuantityUpdateQuantity() {
        return this.quantityUpdateQuantity.getText();
    }

    /**
     * Metoda care returneaza id-ul produsului caruia se doreste schimbarea pretului.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdUpdatePrice() {
        return this.idUpdatePrice.getText();
    }

    /**
     * Metoda care returneaza pretul cu care utilizator vrea sa schimbe pretul produsului existent.
     *
     * @return String pretul dat de catre utilizator.
     */
    public String getPriceUpdatePrice() {
        return this.priceUpdatePrice.getText();
    }

    /**
     * Metoda care returneaza id-ul produsului care se doreste sters din baza de date.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdDelete() {
        return this.idDelete.getText();
    }

    /**
     * Metoda care returneaza id-ul produsului care se doreste sa fie gasit in baza de date.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdFindById() {
        return this.idFindById.getText();
    }

    /**
     * Metoda care seteaza eticheta cu datele produsului gasit sau cu mesajul de eroare.
     *
     * @param message Textul cu care trebuie initializata eticheta.
     */
    public void setProductById(String message) {
        this.productById.setText(message);
    }
}
