package esprit.se.fennira_mohsen_examen.services;

import esprit.se.fennira_mohsen_examen.entities.Client;
import esprit.se.fennira_mohsen_examen.entities.Cuisinier;
import esprit.se.fennira_mohsen_examen.entities.Imc;
import esprit.se.fennira_mohsen_examen.entities.Plat;
import esprit.se.fennira_mohsen_examen.repository.ClientRepo;
import esprit.se.fennira_mohsen_examen.repository.CuisinierRepo;
import esprit.se.fennira_mohsen_examen.repository.PlatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class Services implements IServies {
    @Autowired
    ClientRepo cr;
    @Autowired
    PlatRepo pr;
    @Autowired
    CuisinierRepo cur;

    @Override
    public Client ajouterClient(Client client) {
        return cr.save(client);
    }

    @Override
    public void ajouterCuisinier(Cuisinier cuisinier) {
        cur.save(cuisinier);
    }

    @Override
    public void ajouterPlatAffecterClientEtCuisinier(Plat plat, Integer idClient, Integer idCuisinier) {
        float d=pr.ajouterPlatAffecterClientEtCuisinier(idClient);
        if(d<=2) {
            Client client = cr.findById(idClient).get();
            Plat plat1 = pr.save(plat);
            plat1.setClient(client);
            pr.save(plat1);
            Cuisinier cuisinier = cur.findById(idCuisinier).get();
           //List<Plat>  plat2 = pr.saveAll();
            plat.getCuisinierList().add(cuisinier);
            pr.save(plat1);
        }
    }

    @Override
    public List<Plat> AfficherListePlatsParClient(String nom, String prenom) {
       Client client=cr.findByNomAndPrenom(nom,prenom);
        return client.getPlatList();
    }

    @Override
    public float MontantApayerParClient(Integer idClient) {
        return cr.MontantApayerParClient(idClient);
    }

    @Override
    public void ModifierImc(Integer idClient) {
        Client client= cr.findById(idClient).get();
         Float m=cr.ModifierImc(idClient);
         if(m<2000){
             client.setImc(Imc.valueOf("FAIBLE"));
             cr.save(client);
         }
         else if (m.equals(2000)) {
             client.setImc(Imc.valueOf("IDEAL"));
             cr.save(client);

         }
         else {
             client.setImc(Imc.valueOf("FORT"));
             cr.save(client);

         }
    }

    @Override
    @Scheduled(cron = "*/15 * * * * *")
    public void AfficherListeCuisinier() {
        cur.AfficherListeCuisinier();
        System.out.println(cur);
    }
}
