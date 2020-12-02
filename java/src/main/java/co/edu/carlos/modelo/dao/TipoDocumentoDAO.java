package co.edu.carlos.modelo.dao;

import co.edu.carlos.modelo.dto.TipoDocumentoDTO;

import java.util.Collection;

public interface TipoDocumentoDAO {
    int insert(TipoDocumentoDTO tipoDocumentoDTO);

    int update(TipoDocumentoDTO tipoDocumentoDTO, String primaryKey);

    int delete(String primaryKey);

    Collection<TipoDocumentoDTO> findAll();

    TipoDocumentoDTO findPk(String primaryKey);
}
