package dao;

import connection.ConnectionFactory;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Clasa care contine metodele de accesare a bazei de date specifice tabelei product.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class ProductDAO extends AbstractDAO<Product> {
    /**
     * Metoda care modifica cantitatea unui produs existent in tabela.
     *
     * @param id       Id-ul produsului caruia i se vrea modificata cantitatea.
     * @param quantity Cantitatea care inlocuieste cantitatea curenta a produsului.
     */
    public void updateQuantity(int id, int quantity) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery("quantity", "id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, quantity);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:UpdateQuantity " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Metoda care modifica pretul unui produs existent in tabela.
     *
     * @param id    Id-ul produsului caruia i se vrea modificat pretul.
     * @param price Pretul care inlocuieste pretul curent al produsului.
     */
    public void updatePrice(int id, double price) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery("price", "id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setDouble(1, price);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:UpdateName " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
