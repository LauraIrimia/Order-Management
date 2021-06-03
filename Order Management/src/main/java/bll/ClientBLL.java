package bll;

import dao.ClientDAO;
import model.Client;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa care se ocupa cu logica aplicatiei legata de tabela client.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class ClientBLL {
    private final ClientDAO clientDAO;

    public ClientBLL() {
        clientDAO = new ClientDAO();
    }

    /**
     * Metoda care gaseste un client dupa un id dat prin apelarea metodei din clasa clientDAO care contine metodele de accesare a bazei de date.
     *
     * @param id Id-ul clientului care trebuie cautat.
     * @return Clientul gasit.
     */
    public Client findClientById(int id) {
        Client clt = clientDAO.findById(id);
        if (clt == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return clt;
    }

    /**
     * Metoda care gaseste toti clientii prin apelarea metodei din clasa clientDAO care contine metodele de accesare a bazei de date.
     *
     * @return Lista de clienti gasiti.
     */
    public List<Client> findAllClients() {
        return clientDAO.findAll();
    }

    /**
     * Metoda care adauga un client in tabela prin apelarea metodei din clasa clientDAO care contine metodele de accesare a bazei de date.
     *
     * @param c Clientul care trebuie adaugat.
     */
    public void insertClient(Client c) {
        clientDAO.insert(c);
    }

    /**
     * Metoda care sterge un client din tabela prin apelarea metodei din clasa clientDAO care contine metodele de accesare a bazei de date.
     *
     * @param id Id-ul clientului care trebuie sters.
     */
    public void deleteClient(int id) {
        clientDAO.deleteById(id);
    }

    /**
     * Metoda care modifica numele unui client in functie de id prin apelarea metodei din clasa clientDAO care contine metodele de accesare a bazei de date.
     *
     * @param id   Id-ul clientului care trebuie modificat.
     * @param name Numele cu care se schimba numele clientului actual.
     */
    public void updateName(int id, String name) {
        clientDAO.updateName(id, name);
    }

    /**
     * Metoda care modifica adresa unui client in functie de id prin apelarea metodei din clasa clientDAO care contine metodele de accesare a bazei de date.
     *
     * @param id      Id-ul clientului care trebuie modificat.
     * @param address Adresa cu care se schimba adresa clientului actual.
     */
    public void updateAddress(int id, String address) {
        clientDAO.updateAddress(id, address);
    }
}
