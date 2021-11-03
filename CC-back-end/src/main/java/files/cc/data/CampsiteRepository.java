package files.cc.data;

import files.cc.models.Campsite;

import java.util.List;

public interface CampsiteRepository {
    List<Campsite> findAll();
    Campsite findById(int id);
}
