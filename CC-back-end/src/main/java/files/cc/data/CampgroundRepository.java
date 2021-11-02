package files.cc.data;

import files.cc.models.Campground;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CampgroundRepository {
    List<Campground> findAll() throws DataAccessException;
    Campground findById(int campgroundId) throws DataAccessException;
    //todo: add in findByPrefix/Id - something
    Campground add(Campground campground) throws DataAccessException;
    boolean update(Campground campground) throws DataAccessException;
    boolean deleteById(int campgroundId) throws DataAccessException;
}
