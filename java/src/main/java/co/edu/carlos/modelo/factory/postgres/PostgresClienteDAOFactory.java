package co.edu.carlos.modelo.factory.postgres;

import co.edu.carlos.modelo.dao.ClienteDAO;
import co.edu.carlos.modelo.dao.postgres.PostgresClienteDAO;
import co.edu.carlos.modelo.factory.ClienteDAOFactory;

public class PostgresClienteDAOFactory implements ClienteDAOFactory {
    @Override
    public ClienteDAO create() {
        return new PostgresClienteDAO();
    }
}
