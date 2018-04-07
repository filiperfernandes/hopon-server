package cmu.hopon.repository;

import cmu.hopon.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
    Location findByName(String name);
    Location findById(int id);
}
