package co.edu.carlos.modelo.dao.postgres;

import co.edu.carlos.modelo.dao.ClienteDAO;
import co.edu.carlos.modelo.dto.ClienteDTO;
import co.edu.carlos.modelo.factory.ClienteDAOFactory;
import co.edu.carlos.modelo.factory.postgres.PostgresClienteDAOFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PostgresClienteDAOTest {

    @Test
    void insert() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setSigla("CE");
        clienteDTO.setNumeroDocumento("1001061274");
        clienteDTO.setNombres("Carlos Esteban");
        clienteDTO.setApellidos("Guzman Baquero");

        ClienteDAOFactory fabrica = new PostgresClienteDAOFactory();
        ClienteDAO clienteDAO = fabrica.create();
        assertEquals(clienteDAO.insert(clienteDTO), 1);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findPk() {
    }
}