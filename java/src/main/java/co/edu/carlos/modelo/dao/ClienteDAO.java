package co.edu.carlos.modelo.dao;

import co.edu.carlos.modelo.dto.ClienteDTO;

import java.util.Collection;

public interface ClienteDAO {
    int insert(ClienteDTO clienteDTO);

    int update(ClienteDTO clienteDTO, String primaryKey);

    int delete(String primaryKey);

    Collection<ClienteDTO> findAll();

    ClienteDTO findPk(String primaryKey);
}
