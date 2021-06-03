package dao;

import connection.ConnectionFactory;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 * Clasa care contine metodele de accesare a bazei de date specifice tabelei client.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class ClientDAO extends AbstractDAO<Client> {
    /**
     * Metoda care modifica adresa unui client din tabela.
     *
     * @param id      Id-ul clientului pentru care se doreste modificarea adresei.
     * @param address Adresa care inlocuieste adresa existenta pentru clientul dat.
     */
    public void updateAddress(int id, String address) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery("address", "id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, address);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO:UpdateAddress " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
