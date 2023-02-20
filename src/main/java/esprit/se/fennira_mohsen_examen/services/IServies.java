package esprit.se.fennira_mohsen_examen.services;

import esprit.se.fennira_mohsen_examen.entities.Client;
import esprit.se.fennira_mohsen_examen.entities.Cuisinier;
import esprit.se.fennira_mohsen_examen.entities.Plat;

import java.util.List;

public interface IServies {
    public Client ajouterClient(Client client);
    public void ajouterCuisinier(Cuisinier cuisinier);
    public void ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier);

    List<Plat> AfficherListePlatsParClient(String nom,String prenom);

    public float MontantApayerParClient(Integer idClient);
    public void ModifierImc(Integer idClient);

    public void AfficherListeCuisinier();
}
