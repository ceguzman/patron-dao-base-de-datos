package co.edu.carlos.modelo.factory;

import co.edu.carlos.modelo.dao.ClienteDAO;

public interface ClienteDAOFactory {
    ClienteDAO create();
}
