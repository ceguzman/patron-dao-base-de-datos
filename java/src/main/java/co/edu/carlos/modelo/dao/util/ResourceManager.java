package co.edu.carlos.modelo.dao.util;

import java.sql.*;
import java.util.logging.Logger;

public class ResourceManager {
    private final static String JDBC_URL = "jdbc:postgresql://localhost:5432/tienda";
    private final static String JDBC_USER = "postgres";
    private final static String JDBC_PASSWORD = "123456";

    private static final Logger logger = Logger.getLogger(ResourceManager.class.getName());

    private ResourceManager(){}

    public static synchronized Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
        return connection;
    }

    /**
     * Método me permite cerrar la coneccion
     * @param c objeto de connection que me genera el DriverMana
     */
    public static void close(Connection c) {
        try {
            if (c != null) c.close();
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * Método me permite cerrar el prepared stament
     * @param pr objeto creado a partir de la sentencia SQL
     */
    public static void close(PreparedStatement pr) {
        try {
            if (pr != null) pr.close();
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * Método que me permite cerrar el resulset
     *
     * @param r objeto obtenido de la consulta
     */
    public static void close(ResultSet r) {
        try {
            if (r != null) r.close();
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }
}
