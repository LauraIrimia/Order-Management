package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

/**
 * Clasa care contine metodele de accesare a bazei de date.
 *
 * @author Laura Irimia
 * @version 20.04
 * @since 20.04.2021
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Metoda care creaza query-ul de selectare dupa o anumita coloana.
     *
     * @param field Coloana dupa care trebuie selectata linia din tabela.
     * @return String query-ul.
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Metoda care creaza query-ul de selectare a tuturor elementelor dintr-o tabela.
     *
     * @return String query-ul.
     */
    private String createSelectAllQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * Metoda care creaza query-ul de inserare a unui rand intr-o tabela.
     *
     * @return String query-ul.
     */
    public String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append(" (");
        int i = 0;
        for (Field field : type.getDeclaredFields()) {
            String fieldName = field.getName();
            i++;
            if (i == type.getDeclaredFields().length) {
                sb.append(fieldName + ")");
            } else {
                sb.append(fieldName + ",");
            }
        }
        sb.append(" VALUES ");
        sb.append("(");
        for (int j = 0; j < i; j++) {
            if (j == i - 1) {
                sb.append("?)");
            } else {
                sb.append("?,");
            }
        }
        return sb.toString();
    }

    /**
     * Metoda care creaza query-ul de stergere a unui rand dintr-o tabela.
     *
     * @param field Coloana in functie de care cautam randul care trebuie sters.
     * @return String query-ul.
     */
    private String createDeleteQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append("FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Metoda care creaza query-ul de modificare a unui camp de pe un rand in functie de o coloana.
     *
     * @param column Campul care se vrea modificat.
     * @param field  Coloana dupa care se cauta randul care trebuie modificat.
     * @return String query-ul.
     */
    public String createUpdateQuery(String column, String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET " + column + " =?");
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Metoda care gaseste toate elementele dintr-o tabela.
     *
     * @return Lista de elemente din tabela.
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Metoda care cauta un element intr-o tabela dupa id.
     *
     * @param id Id-ul elementului cautat.
     * @return Elementul cautat.
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            List<T> listO = createObjects(resultSet);
            if (listO.isEmpty())
                return null;
            else return listO.get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Metoda care adauga un element intr-o tabela.
     *
     * @param t Elementul care trebuie adaugat.
     * @return Elementul primit ca parametru.
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i = 1;
            for (Field field : type.getDeclaredFields()) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                statement.setObject(i++, method.invoke(t));
            }
            statement.executeUpdate();
            return t;
        } catch (SQLException | IntrospectionException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:Insert " + e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Metoda care sterge un element dintr-o tabela in functie de id.
     *
     * @param id Id-ul elementului care se vrea sters.
     */
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:deleteById " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Metoda care modifica numele unui client sau a unui produs din tabele.
     *
     * @param id   Id-ul clientului/produsului caruia i se vrea schimbat numele.
     * @param name Numele cu care se vrea sa fie schimbat numele existent.
     */
    public void updateName(int id, String name) {
        // PENTRU ORDER NU SE FOLOSESTE FUNCTIA DIN ABSTRACTdao, CI FUNCTIA DIN ORDERdao
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
            LOGGER.log(Level.WARNING, type.getName() + "DAO:UpdateName " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Metoda care creeaza o lista de elemente care se afla intr-o anumita tabela in functie de rezultatul returnat de query.
     *
     * @param resultSet Rezultatul returnat de query-ul efectuat.
     * @return Lista de elemente gasite in rezultatul returnat de query.
     */
    public List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

}
