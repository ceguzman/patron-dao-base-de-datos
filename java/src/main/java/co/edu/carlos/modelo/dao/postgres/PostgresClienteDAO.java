package co.edu.carlos.modelo.dao.postgres;

import co.edu.carlos.modelo.dao.ClienteDAO;
import co.edu.carlos.modelo.dao.util.ResourceManager;
import co.edu.carlos.modelo.dto.ClienteDTO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
        int registroBorrado = 0;
        String sql = "DELETE FROM public.cliente WHERE sigla=?;";
        PreparedStatement sentencia = null;
        try {
            connection = ResourceManager.getConnection();
            sentencia = connection.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            registroBorrado = sentencia.executeUpdate();
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
        return registroBorrado;
    }

    @Override
    public Collection<ClienteDTO> findAll() {
        List<ClienteDTO> listaClientes = new ArrayList();
        String sql = "SELECT * FROM public.cliente";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            connection = ResourceManager.getConnection();
            sentencia = connection.prepareStatement(sql);
            sentencia.executeQuery();

            while (resultado.next()) {
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setSigla(resultado.getString("sigla"));
                clienteDTO.setNumeroDocumento(resultado.getString("numero_documento"));
                clienteDTO.setNombres(resultado.getString("nombres"));
                clienteDTO.setApellidos(resultado.getString("apellidos"));
                listaClientes.add(clienteDTO);
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
        } finally {
            ResourceManager.close(resultado);
            ResourceManager.close(sentencia);
            ResourceManager.close(connection);
        }
        return listaClientes;
    }

    @Override
    public ClienteDTO findPk(String primaryKey) {
        ClienteDTO clienteDTO = new ClienteDTO();
        String sql = "SELECT * FROM public.cliente WHERE sigla=?;";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            connection = ResourceManager.getConnection();
            sentencia = connection.prepareStatement(sql);
            sentencia.executeQuery();

            while (resultado.next()) {
                clienteDTO.setSigla(resultado.getString("sigla"));
                clienteDTO.setNumeroDocumento(resultado.getString("numero_documento"));
                clienteDTO.setNombres(resultado.getString("nombres"));
                clienteDTO.setApellidos(resultado.getString("apellidos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clienteDTO;
    }
}
