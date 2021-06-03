package bll;

import dao.OrderDAO;
import model.Ordeer;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa care se ocupa cu logica aplicatiei legata de tabela ordeer.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class OrderBLL {
    private final OrderDAO orderDAO;

    public OrderBLL() {
        orderDAO = new OrderDAO();
    }

    /**
     * Metoda care gaseste o comanda dupa un id dat prin apelarea metodei din clasa orderDAO care contine metodele de accesare a bazei de date.
     *
     * @param id Id-ul comenzii care trebuie cautata.
     * @return Comanda gasita.
     */
    public Ordeer findOrderById(int id) {
        Ordeer ord = orderDAO.findById(id);
        if (ord == null) {
            throw new NoSuchElementException("The order with id =" + id + " was not found!");
        }
        return ord;
    }

    /**
     * Metoda care gaseste toate comenzile prin apelarea metodei din clasa orderDAO care contine metodele de accesare a bazei de date.
     *
     * @return Lista de comenzi gasite.
     */
    public List<Ordeer> findAllOrders() {
        return orderDAO.findAll();
    }

    /**
     * Metoda care adauga o comanda in tabela prin apelarea metodei din clasa orderDAO care contine metodele de accesare a bazei de date.
     *
     * @param o Comanda care trebuie adaugata.
     */
    public void insertOrder(Ordeer o) {
        orderDAO.insert(o);
    }

    /**
     * Metoda care sterge o comanda din tabela prin apelarea metodei din clasa orderDAO care contine metodele de accesare a bazei de date.
     *
     * @param id Id-ul comenzii care trebuie stearsa.
     */
    public void deleteOrder(int id) {
        orderDAO.deleteById(id);
    }

    /**
     * Metoda care modifica numele unui client dintr-o comanda in functie de id prin apelarea metodei din clasa orderDAO care contine metodele de accesare a bazei de date.
     *
     * @param id   Id-ul comenzii care trebuie modificata.
     * @param name Numele cu care se schimba numele clientului din comanda actuala.
     */
    public void updateClientName(int id, String name) {
        orderDAO.updateClientName(id, name);
    }

    /**
     * Metoda care modifica numele unui produs dintr-o comanda in functie de id prin apelarea metodei din clasa orderDAO care contine metodele de accesare a bazei de date.
     *
     * @param id   Id-ul comenzii care trebuie modificata.
     * @param name Numele cu care se schimba numele produsului din comanda actuala.
     */
    public void updateProductName(int id, String name) {
        orderDAO.updateProductName(id, name);
    }

    /**
     * Metoda care modifica cantitatea unui produs dintr-o comanda in functie de id prin apelarea metodei din clasa orderDAO care contine metodele de accesare a bazei de date.
     *
     * @param id       Id-ul comenzii care trebuie modificata.
     * @param quantity Cantitatea cu care se schimba cantitatea produsului din comanda actuala.
     */
    public void updateQuantity(int id, int quantity) {
        orderDAO.updateQuantity(id, quantity);
    }

    /**
     * Metoda care modifica pretul unei comanzi in functie de id prin apelarea metodei din clasa orderDAO care contine metodele de accesare a bazei de date.
     *
     * @param id    Id-ul comenzii care trebuie modificata.
     * @param price Pretul cu care se schimba pretul comenzii actuale.
     */
    public void updatePrice(int id, double price) {
        orderDAO.updatePrice(id, price);
    }

}
