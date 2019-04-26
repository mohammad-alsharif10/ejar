package apartment.ejar.repositories;

import apartment.ejar.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location, Integer> {

    Location findByArabicNameContaining(String name);
}
