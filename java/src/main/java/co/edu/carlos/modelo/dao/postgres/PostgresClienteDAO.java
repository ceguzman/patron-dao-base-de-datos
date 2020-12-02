package co.edu.carlos.modelo.dao.postgres;

import co.edu.carlos.modelo.dao.ClienteDAO;
import co.edu.carlos.modelo.dao.util.ResourceManager;
import co.edu.carlos.modelo.dto.ClienteDTO;
import co.edu.carlos.modelo.dto.TipoDocumentoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Logger;

public class PostgresClienteDAO implements ClienteDAO {

    private Connection connection;
    private static final Logger logger = Logger.getLogger(PostgresClienteDAO.class.getName());

    @Override
    public int insert(ClienteDTO clienteDTO) {
        int datosInsertados = 0;
        String sql = "INSERT INTO public.cliente(sigla, numero_documento, nombres, apellidos) VALUES (?, ?, ?, ?);";
        PreparedStatement sentencia = null;
        try {
            connection = ResourceManager.getConnection();
            sentencia = connection.prepareStatement(sql);
            sentencia.setString(1, clienteDTO.getSigla());
            sentencia.setString(2, clienteDTO.getNumeroDocumento());
            sentencia.setString(3, clienteDTO.getNombres());
            sentencia.setString(4, clienteDTO.getApellidos());
            datosInsertados = sentencia.executeUpdate();
        } catch (SQLException e) {
            logger.info(e.getMessage());
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(connection);
        }
        return datosInsertados;
    }

    @Override
    public int update(ClienteDTO clienteDTO, String primaryKey) {
        int datosActualizados = 0;
        String sql = "UPDATE public.cliente SET sigla=?, numero_documento=?, nombres=?, apellidos=?  WHERE sigla=?;";
        PreparedStatement sentencia = null;
        try {
            connection = ResourceManager.getConnection();
            sentencia = connection.prepareStatement(sql);
            sentencia.setString(1, clienteDTO.getSigla());
            sentencia.setString(2, clienteDTO.getNumeroDocumento());
            sentencia.setString(3, clienteDTO.getNombres());
            sentencia.setString(4, clienteDTO.getApellidos());
            datosActualizados = sentencia.executeUpdate();
        } catch (SQLException e) {
            logger.info(e.getMessage());
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(connection);
        }
        return datosActualizados;
    }

    @Override
    public int delete(String primaryKey) {
        return 0;
    }

    @Override
    public Collection<ClienteDTO> findAll() {
        return null;
    }

    @Override
    public ClienteDTO findPk(String primaryKey) {
        return null;
    }
}
