package springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springbootbackend.entity.Details;
import springbootbackend.entity.DetailsId;

import java.util.List;
//import springbootbackend.entity.DetailsId;

@Repository
public interface DetailsRepository extends JpaRepository<Details, DetailsId> {
//    @Query("SELECT new springbootbackend.entity.PokemonName(poke.p) "
//            + "FROM PokemonName poke")
//    List<PokemonName> findAllCards();

//    @Query("SELECT p FROM PokemonName p")
//    List<PokemonName> findAllCards1();

    // find Details by species name
    @Query("SELECT d FROM Details d WHERE d.spcName = :spcName")
    List<Details> findDetails(@Param("spcName") String spcName);
}
