package springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootbackend.entity.PowerType;

@Repository

public interface PowerTypeRepository extends JpaRepository<PowerType, String>{
//    @Query("SELECT new main.entities.Owner(o.ownerId, o.firstname, o.lastname) "
//            + "FROM Owner o")
//    List<Owner> findAllOwners();
}
