package co.edu.carlos.modelo.factory.postgres;

import co.edu.carlos.modelo.dao.TipoDocumentoDAO;
import co.edu.carlos.modelo.dao.postgres.PostgresTipoDocumentoDAO;
import co.edu.carlos.modelo.factory.TipoDocumentoDAOFactory;

public class PostgresTipoDocumentoDAOFactory implements TipoDocumentoDAOFactory {

    @Override
    public TipoDocumentoDAO create() {
        return new PostgresTipoDocumentoDAO();
    }
}
