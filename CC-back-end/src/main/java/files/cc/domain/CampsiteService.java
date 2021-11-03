package files.cc.domain;

import files.cc.data.CampsiteRepository;
import files.cc.models.Campsite;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampsiteService {

    private final CampsiteRepository repository;

    public CampsiteService(CampsiteRepository repository) {
        this.repository = repository;
    }

    public List<Campsite> findAll() throws DataAccessException {
        return repository.findAll();
    }

    public Campsite findById(int id) throws DataAccessException{
        return repository.findById(id);
    }
}
