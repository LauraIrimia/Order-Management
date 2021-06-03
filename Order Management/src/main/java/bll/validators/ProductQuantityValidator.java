package bll.validators;

import model.Product;
/**
 * Clasa care contine metoda de validare a cantitatii unui produs.
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class ProductQuantityValidator implements Validator<Product>{
    private static final int MIN_QUANTITY = 5;
    private static final int MAX_QUANTITY = 50;

    /**
     * Metoda care verifica daca cantitatea introdusa se afla in intervalul dorit.
     *
     * @param product Produsul pentru care se face validarea.
     */
    @Override
    public void validate(Product product) {
        if (product.getQuantity() < MIN_QUANTITY || product.getQuantity() > MAX_QUANTITY) {
            throw new IllegalArgumentException("The Product Quantity limit is not respected!\nMIN: "+MIN_QUANTITY +"\nMAX: "+MAX_QUANTITY);
        }

    }
}
