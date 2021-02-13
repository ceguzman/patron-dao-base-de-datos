package co.edu.carlos.modelo.dao.postgres;

import co.edu.carlos.modelo.dao.TipoDocumentoDAO;
import co.edu.carlos.modelo.dao.util.ResourceManager;
import co.edu.carlos.modelo.dto.TipoDocumentoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class PostgresTipoDocumentoDAO implements TipoDocumentoDAO {

    private Connection connection;
    private static final Logger logger = Logger.getLogger(PostgresTipoDocumentoDAO.class.getName());

    /**
     * Metodo insert de la tabla tipo_documento
     *
     * @param tipoDocumentoDTO objeto de tipo documlento
     * @return los datos insertados
     */
    @Override
    public int insert(TipoDocumentoDTO tipoDocumentoDTO) {
        int datosInsertados = 0;
        String sql = "INSERT INTO public.tipo_documento(sigla, nombre, estado)   VALUES (?, ?, ?);";
        PreparedStatement sentencia = null;
        try {
            connection = ResourceManager.getConnection();
            sentencia = connection.prepareStatement(sql);
            sentencia.setString(1, tipoDocumentoDTO.getSigla());
            sentencia.setString(2, tipoDocumentoDTO.getNombre());
            sentencia.setString(3, tipoDocumentoDTO.getEstado());
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
    public int update(TipoDocumentoDTO tipoDocumentoDTO, String primaryKey) {
        int datosActualizados = 0;
        String sql = "UPDATE public.tipo_documento  SET sigla=?, nombre=?, estado=?  WHERE sigla = ?;";
        PreparedStatement sentencia = null;
        try {
            connection = ResourceManager.getConnection();
            sentencia = connection.prepareStatement(sql);
            sentencia.setString(1, tipoDocumentoDTO.getSigla());
            sentencia.setString(2, tipoDocumentoDTO.getNombre());
            sentencia.setString(3, tipoDocumentoDTO.getEstado());
            sentencia.setString(4, primaryKey);
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
        int datoDelete = 0;
        String sql = "DELETE FROM public.tipo_documento  WHERE sigla = ?;";
        PreparedStatement sentencia = null;
        try {
            connection = ResourceManager.getConnection();
            sentencia = connection.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            datoDelete = sentencia.executeUpdate();
        } catch (SQLException e) {
            logger.info(e.getMessage());
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(connection);
        }
        return datoDelete;
    }

    @Override
    public Collection<TipoDocumentoDTO> findAll() {
        List<TipoDocumentoDTO> listaTipoDocumentos = new ArrayList<>();
        String sql = "SELECT sigla, nombre, estado FROM public.tipo_documento;";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            connection = ResourceManager.getConnection();
            sentencia = connection.prepareStatement(sql);
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
                tipoDocumentoDTO.setSigla(resultado.getString("sigla"));
                tipoDocumentoDTO.setNombre(resultado.getString("nombre"));
                tipoDocumentoDTO.setEstado(resultado.getString("estado"));
                listaTipoDocumentos.add(tipoDocumentoDTO);
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
        } finally {
            ResourceManager.close(resultado);
            ResourceManager.close(sentencia);
            ResourceManager.close(connection);
        }
        return listaTipoDocumentos;
    }

    @Override
    public TipoDocumentoDTO findPk(String primaryKey) {
        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
        String sql = "SELECT sigla, nombre, estado FROM public.tipo_documento WHERE sigla = ?;";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            connection = ResourceManager.getConnection();
            sentencia = connection.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                tipoDocumentoDTO.setSigla(resultado.getString("sigla"));
                tipoDocumentoDTO.setNombre(resultado.getString("nombre"));
                tipoDocumentoDTO.setEstado(resultado.getString("estado"));
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
        } finally {
            ResourceManager.close(resultado);
            ResourceManager.close(sentencia);
            ResourceManager.close(connection);
        }
        return tipoDocumentoDTO;
    }
}
