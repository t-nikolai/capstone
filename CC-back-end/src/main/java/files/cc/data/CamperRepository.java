package files.cc.data;

import files.cc.models.Camper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CamperRepository {
    List<Camper> findAll();

    Camper findById(int camper_id);

    // override too!
    @Transactional
    Camper add(Camper camper);

    boolean update(Camper camper);

    boolean deleteById(int camper_id);
}
