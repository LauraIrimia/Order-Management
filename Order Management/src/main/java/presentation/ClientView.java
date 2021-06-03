package presentation;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

/**
 * Clasa care implementeaza interfata grafica pentru tabelul client.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class ClientView extends JFrame {

    private final JTextField idInsert;
    private final JTextField nameInsert;
    private final JTextField addressInsert;
    private final JTextField idUpdateName;
    private final JTextField nameUpdateName;
    private final JTextField idUpdateAddress;
    private final JTextField addressUpdateAddress;
    private final JTextField idDelete;
    private final JTextField idFindById;
    private final JLabel clientById;
    private final JButton insert;
    private final JButton updateAddress;
    private final JButton updateName;
    private final JButton delete;
    private final JButton findById;
    private final JButton findAll;

    /**
     * Implementarea ferestrei grafice.
     */
    public ClientView() {
        setTitle("Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 50, 500, 300);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        insert = new JButton("Insert");
        panel1.add(insert);
        JLabel lblNewLabel1 = new JLabel("new client ");
        panel1.add(lblNewLabel1);
        idInsert = new JTextField(10);
        idInsert.setToolTipText("Id");
        panel1.add(idInsert);
        nameInsert = new JTextField(10);
        nameInsert.setToolTipText("Name");
        panel1.add(nameInsert);
        addressInsert = new JTextField(10);
        addressInsert.setToolTipText("Address");
        panel1.add(addressInsert);
        contentPane.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        updateName = new JButton("Update");
        panel2.add(updateName);
        JLabel lblNewLabel2 = new JLabel("client name ");
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
        updateAddress = new JButton("Update");
        panel3.add(updateAddress);
        JLabel lblNewLabel3 = new JLabel("client address ");
        panel3.add(lblNewLabel3);
        idUpdateAddress = new JTextField(10);
        idUpdateAddress.setToolTipText("Id");
        panel3.add(idUpdateAddress);
        addressUpdateAddress = new JTextField(10);
        addressUpdateAddress.setToolTipText("Address");
        panel3.add(addressUpdateAddress);
        contentPane.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        delete = new JButton("Delete");
        panel4.add(delete);
        JLabel lblNewLabel4 = new JLabel("client ");
        panel4.add(lblNewLabel4);
        idDelete = new JTextField(10);
        idDelete.setToolTipText("Id");
        panel4.add(idDelete);
        contentPane.add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());
        findById = new JButton("Find");
        panel5.add(findById);
        JLabel lblNewLabel5 = new JLabel("client with id ");
        panel5.add(lblNewLabel5);
        idFindById = new JTextField(10);
        idFindById.setToolTipText("Id");
        panel5.add(idFindById);
        contentPane.add(panel5);

        JPanel panel51 = new JPanel();
        panel51.setLayout(new FlowLayout());
        clientById = new JLabel("");
        panel51.add(clientById);
        contentPane.add(panel51);

        JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout());
        findAll = new JButton("Find");
        panel6.add(findAll);
        JLabel lblNewLabel6 = new JLabel("all clients ");
        panel6.add(lblNewLabel6);
        contentPane.add(panel6);

    }

    /**
     * Adaugarea de ascultator pentru butonul de inserare a unui client in tabela.
     *
     * @param actionListener Ascultatorul.
     */
    public void addInsertBtnListener(ActionListener actionListener) {
        this.insert.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de modificare a namelui unui client din tabela.
     *
     * @param actionListener Ascultatorul.
     */
    public void addUpdateNameBtnListener(ActionListener actionListener) {
        this.updateName.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de modificare a adresei unui client din tabela.
     *
     * @param actionListener Ascultatorul.
     */
    public void addUpdateAddressBtnListener(ActionListener actionListener) {
        this.updateAddress.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de stergere a unui client din tabela.
     *
     * @param actionListener Ascultatorul.
     */
    public void addDeleteBtnListener(ActionListener actionListener) {
        this.delete.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de cautare a unui client din tabela dupa id.
     *
     * @param actionListener Ascultatorul.
     */
    public void addFindByIdBtnListener(ActionListener actionListener) {
        this.findById.addActionListener(actionListener);
    }

    /**
     * Adaugarea de ascultator pentru butonul de afisare a tuturor clientilor din tabela sub forma de JTabel.
     *
     * @param actionListener Ascultatorul.
     */
    public void addFindAllBtnListener(ActionListener actionListener) {
        this.findAll.addActionListener(actionListener);
    }

    /**
     * Metoda care returneaza id-ul clientului care se vrea sa fie inserat de utilizator.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdInsert() {
        return this.idInsert.getText();
    }

    /**
     * Metoda care returneaza numele clientului care se vrea sa fie inserat de utilizator.
     *
     * @return String numele dat de catre utilizator.
     */
    public String getNameInsert() {
        return this.nameInsert.getText();
    }

    /**
     * Metoda care returneaza adresa clientului care se vrea sa fie inserat de utilizator.
     *
     * @return String adresa data de catre utilizator.
     */
    public String getAddressInsert() {
        return this.addressInsert.getText();
    }

    /**
     * Metoda care returneaza id-ul clientului caruia se doreste schimbarea numelui.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdUpdateName() {
        return this.idUpdateName.getText();
    }

    /**
     * Metoda care returneaza numele cu care utilizator vrea sa schimbe numele clientului existent.
     *
     * @return String numele dat de catre utilizator.
     */
    public String getNameUpdateName() {
        return this.nameUpdateName.getText();
    }

    /**
     * Metoda care returneaza id-ul clientului caruia se doreste schimbarea adresei.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdUpdateAddress() {
        return this.idUpdateAddress.getText();
    }

    /**
     * Metoda care returneaza adresa cu care utilizator vrea sa schimbe adresa clientului existent.
     *
     * @return String adresa data de catre utilizator.
     */
    public String getAddressUpdateAddress() {
        return this.addressUpdateAddress.getText();
    }

    /**
     * Metoda care returneaza id-ul clientului care se doreste sters din baza de date.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdDelete() {
        return this.idDelete.getText();
    }

    /**
     * Metoda care returneaza id-ul clientului care se doreste sa fie gasit in baza de date.
     *
     * @return String id-ul dat de catre utilizator.
     */
    public String getIdFindById() {
        return this.idFindById.getText();
    }

    /**
     * Metoda care seteaza eticheta cu datele clientului gasit sau cu mesajul de eroare.
     *
     * @param message Textul cu care trebuie initializata eticheta.
     */
    public void setClientById(String message) {
        this.clientById.setText(message);
    }

}
