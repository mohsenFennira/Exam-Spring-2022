package esprit.se.fennira_mohsen_examen.repository;

import esprit.se.fennira_mohsen_examen.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client,Integer> {
    Client findByNomAndPrenom(String nom,String Prenom);
    @Query("select SUM (p.prix) from Plat p ,Client c  where p.client.idClient=:id")
    public float MontantApayerParClient(@Param("id") Integer idClient);
    @Query("select SUM (p.calories) from Plat p ,Client c  where p.client.idClient=:id")
    public Float ModifierImc(@Param("id")Integer idClient);
}
