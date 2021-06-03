package bll.validators;

/**
 * Interfata care contine metoda de validare a unei intrari.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public interface Validator<T> {
    /**
     * Metoda de validare a unui obiect.
     *
     * @param t Obiectul de validat.
     */
    void validate(T t);
}
