package apartment.ejar.repositories;

import apartment.ejar.entities.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {

    Apartment findByAddressContaining(String address);

    @RestResource(path = "created-by", rel = "created-by")
    Page<Apartment> findByCreatedBy(@Param("username") String username, Pageable pageable);
}
