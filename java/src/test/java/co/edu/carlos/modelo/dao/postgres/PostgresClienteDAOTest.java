package co.edu.carlos.modelo.dao.postgres;

import co.edu.carlos.modelo.dao.ClienteDAO;
import co.edu.carlos.modelo.dto.ClienteDTO;
import co.edu.carlos.modelo.factory.ClienteDAOFactory;
import co.edu.carlos.modelo.factory.postgres.PostgresClienteDAOFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PostgresClienteDAOTest {


    @Test
    void insert() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setSigla("CE");
        clienteDTO.setNumeroDocumento("1001201789");
        clienteDTO.setNombres("Carlos Esteban");
        clienteDTO.setApellidos("Guzman Baquero");

        ClienteDAOFactory fabrica = new PostgresClienteDAOFactory();
        ClienteDAO clienteDAO = fabrica.create();
        assertEquals(clienteDAO.insert(clienteDTO), 1);
    }

    @Test
    void update() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setSigla("CE");
        clienteDTO.setNumeroDocumento("1001201789");
        clienteDTO.setNombres("Jessica");
        clienteDTO.setApellidos("Granados Hernandez");

        ClienteDAOFactory fabrica = new PostgresClienteDAOFactory();
        ClienteDAO clienteDAO = fabrica.create();
        assertEquals(clienteDAO.update(clienteDTO, "CE", "1001201789"), 1);
    }

    @Test
    void delete() {
        ClienteDTO clienteDTO = new ClienteDTO();

        ClienteDAOFactory fabrica = new PostgresClienteDAOFactory();
        ClienteDAO clienteDAO = fabrica.create();
        assertEquals(clienteDAO.delete("CE", "1001061274"), 1);
    }

    @Test
    void findAll() {
        ClienteDAOFactory fabrica = new PostgresClienteDAOFactory();
        ClienteDAO clienteDAO = fabrica.create();
        assertFalse(clienteDAO.findAll().isEmpty());
    }

    @Test
    void findPk() {
        ClienteDAOFactory fabrica = new PostgresClienteDAOFactory();
        ClienteDAO clienteDAO = fabrica.create();
        assertNotEquals(clienteDAO.findPk("CE","1001201789"), null);
    }
}