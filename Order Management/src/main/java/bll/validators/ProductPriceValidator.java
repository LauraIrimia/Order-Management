package bll.validators;

import model.Product;

/**
 * Clasa care contine metoda de validare a pretului unui produs.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class ProductPriceValidator implements Validator<Product> {
    private static final double MIN_PRICE = 10;
    private static final double MAX_PRICE = 500;

    /**
     * Metoda care verifica daca pretul introdus se afla in intervalul dorit.
     *
     * @param product Produsul pentru care se face validarea.
     */
    @Override
    public void validate(Product product) {
        if (product.getPrice() < MIN_PRICE || product.getPrice() > MAX_PRICE) {
            throw new IllegalArgumentException("The Product Price limit is not respected!\nMIN: " + MIN_PRICE + "\nMAX: " + MAX_PRICE);
        }

    }
}
