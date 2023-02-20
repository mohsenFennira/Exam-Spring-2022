package esprit.se.fennira_mohsen_examen.repository;

import esprit.se.fennira_mohsen_examen.entities.Plat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatRepo extends CrudRepository<Plat,Integer> {
    @Query("select count(p) from Client c ,Plat p where c.idClient=:d and p.categorie='PRINCIPALE'")
    public float ajouterPlatAffecterClientEtCuisinier(@Param("d") Integer idClient);
}
