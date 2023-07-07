package springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springbootbackend.entity.Details;
import springbootbackend.entity.Species;

import java.util.List;

@Repository

public interface SpeciesRepository extends JpaRepository<Species, String> {// String cos follow the PowerType type int

//    @Query("SELECT g FROM Game g WHERE g.platform = :platform")
//    List<Game> findGamesByPlatform(@Param("platform") String platform);


}
