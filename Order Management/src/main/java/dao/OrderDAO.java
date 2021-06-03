package dao;

import connection.ConnectionFactory;
import model.Ordeer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Clasa care contine metodele de accesare a bazei de date specifice tabelei ordeer.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class OrderDAO extends AbstractDAO<Ordeer> {
    /**
     * Metoda care modifica numele clientului unei comenzi din tabela.
     *
     * @param id   Id-ul comenzii care se vrea modificata.
     * @param name Numele cu care se vrea schimbat numele clientuluii comezii actuale.
     */
    public void updateClientName(int id, String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery("name", "id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:UpdateClientName " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Metoda care modifica numele produsului dintr-o comanda din tabela.
     *
     * @param id   Id-ul comenzii care se vrea modificata.
     * @param name Numele produsului care va inlocui numele actual al produsului din comanda.
     */
    public void updateProductName(int id, String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery("name", "id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO:UpdateProductName " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Metoda care modifica cantitatea produsului dintr-o comanda din tabela.
     *
     * @param id       Id-ul comenzii asupra caruia dorim sa facem modificarea.
     * @param quantity Canitatea care va inlocui cantitatea curenta a produsului aflat in comanda.
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
            LOGGER.log(Level.WARNING, "OrderDAO:UpdateQuantity " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Metoda care modifica pretul unei comenzi din tabela.
     *
     * @param id    Id-ul comenzii asupra caruia dorim sa facem modificarea.
     * @param price Pretul care va inlocui pretul curent a comenzii.
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
            LOGGER.log(Level.WARNING, "OrderDAO:UpdatePrice " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

}
