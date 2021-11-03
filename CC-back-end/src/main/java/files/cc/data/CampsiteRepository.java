package files.cc.data;

import files.cc.models.Campsite;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CampsiteRepository {
    List<Campsite> findAll() throws DataAccessException;
    Campsite findById(int id) throws DataAccessException;
}
