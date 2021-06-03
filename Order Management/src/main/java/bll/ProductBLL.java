package bll;

import bll.validators.ProductPriceValidator;
import bll.validators.ProductQuantityValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa care se ocupa cu logica aplicatiei legata de tabela product.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class ProductBLL {
    private final List<Validator<Product>> validators;
    private final ProductDAO productDAO;

    public ProductBLL() {
        validators = new ArrayList<>();
        validators.add(new ProductQuantityValidator());
        validators.add(new ProductPriceValidator());
        productDAO = new ProductDAO();
    }

    /**
     * Metoda care gaseste un produs dupa un id dat prin apelarea metodei din clasa productDAO care contine metodele de accesare a bazei de date.
     *
     * @param id Id-ul produsului care trebuie cautat.
     * @return Produsul gasit.
     */
    public Product findProductById(int id) {
        Product prd = productDAO.findById(id);
        if (prd == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return prd;
    }

    /**
     * Metoda care gaseste toate produsele prin apelarea metodei din clasa productDAO care contine metodele de accesare a bazei de date.
     *
     * @return Lista de produse gasite.
     */
    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

    /**
     * Metoda care adauga un produs in tabela prin apelarea metodei din clasa productDAO care contine metodele de accesare a bazei de date.
     *
     * @param p Produsul care trebuie adaugat.
     */
    public void insertProduct(Product p) {
        productDAO.insert(p);
    }

    /**
     * Metoda care sterge un produs din tabela prin apelarea metodei din clasa productDAO care contine metodele de accesare a bazei de date.
     *
     * @param id Id-ul produsului care trebuie sters.
     */
    public void deleteProduct(int id) {
        productDAO.deleteById(id);
    }

    /**
     * Metoda care modifica numele unui produs in functie de id prin apelarea metodei din clasa productDAO care contine metodele de accesare a bazei de date.
     *
     * @param id   Id-ul produsului care trebuie modificat.
     * @param name Numele cu care se schimba numele produsului actual.
     */
    public void updateName(int id, String name) {
        productDAO.updateName(id, name);
    }

    /**
     * Metoda care modifica cantitatea unui produs in functie de id prin apelarea metodei din clasa productDAO care contine metodele de accesare a bazei de date.
     *
     * @param id       Id-ul produsului care trebuie modificat.
     * @param quantity Cantitatea cu care se schimba cantitatea produsului actual.
     */
    public void updateQuantity(int id, int quantity) {
        productDAO.updateQuantity(id, quantity);
    }

    /**
     * Metoda care modifica pretul unui produs in functie de id prin apelarea metodei din clasa productDAO care contine metodele de accesare a bazei de date.
     *
     * @param id    Id-ul produsului care trebuie modificat.
     * @param price Pretul cu care se schimba pretul produsului actual.
     */
    public void updatePrice(int id, double price) {
        productDAO.updatePrice(id, price);
    }

    /**
     * Metoda care obtine validatorii declarati pentru clasa curenta pentru a valida o intrare.
     *
     * @return Lista de validatori.
     */
    public List<Validator<Product>> getValidators() {
        return validators;
    }
}
