package esprit.se.fennira_mohsen_examen.repository;

import esprit.se.fennira_mohsen_examen.entities.Cuisinier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Repository
public interface CuisinierRepo extends CrudRepository<Cuisinier,Integer> {
    @Query("select c from Cuisinier c where c.plats.size=2")
    public void AfficherListeCuisinier();
}

