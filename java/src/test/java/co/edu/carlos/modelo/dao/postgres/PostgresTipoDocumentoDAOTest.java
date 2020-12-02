package co.edu.carlos.modelo.dao.postgres;

import co.edu.carlos.modelo.dao.TipoDocumentoDAO;
import co.edu.carlos.modelo.dto.TipoDocumentoDTO;
import co.edu.carlos.modelo.factory.TipoDocumentoDAOFactory;
import co.edu.carlos.modelo.factory.postgres.PostgresTipoDocumentoDAOFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostgresTipoDocumentoDAOTest {

    @Test
    void insert() {
        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
        tipoDocumentoDTO.setSigla("CE");
        tipoDocumentoDTO.setNombre("Cédula Extranjera");
        tipoDocumentoDTO.setEstado("Activo");

        TipoDocumentoDAOFactory fabrica = new PostgresTipoDocumentoDAOFactory();
        TipoDocumentoDAO daoTipoDocumento = fabrica.create();
        assertEquals(daoTipoDocumento.insert(tipoDocumentoDTO), 1);
    }

    @Test
    void update() {
        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
        tipoDocumentoDTO.setSigla("CE");
        tipoDocumentoDTO.setNombre("Cedula Extranjera");
        tipoDocumentoDTO.setEstado("Activo");

        TipoDocumentoDAOFactory fabrica = new PostgresTipoDocumentoDAOFactory();
        TipoDocumentoDAO daoTipoDocumento = fabrica.create();
        assertEquals(daoTipoDocumento.update(tipoDocumentoDTO, "CC"), 1);
    }

    @Test
    void delete() {
        TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();

        TipoDocumentoDAOFactory fabrica = new PostgresTipoDocumentoDAOFactory();
        TipoDocumentoDAO daoTipoDocumento = fabrica.create();
        assertEquals(daoTipoDocumento.delete("CE"), 1);
    }

    @Test
    void findAll() {
        TipoDocumentoDAOFactory fabrica = new PostgresTipoDocumentoDAOFactory();
        TipoDocumentoDAO daoTipoDocumento = fabrica.create();
        assertFalse(daoTipoDocumento.findAll().isEmpty());
    }

    @Test
    void findPk() {
        TipoDocumentoDAOFactory fabrica = new PostgresTipoDocumentoDAOFactory();
        TipoDocumentoDAO daoTipoDocumento = fabrica.create();
        assertNotEquals(daoTipoDocumento.findPk("CE"), null);
    }
}