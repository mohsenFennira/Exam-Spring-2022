package esprit.se.fennira_mohsen_examen.controller;

import esprit.se.fennira_mohsen_examen.entities.Client;
import esprit.se.fennira_mohsen_examen.entities.Cuisinier;
import esprit.se.fennira_mohsen_examen.entities.Plat;
import esprit.se.fennira_mohsen_examen.services.IServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
   @Autowired
    IServies is;

   @PostMapping("ajouterClient")
   public Client ajouterClient(@RequestBody Client client) {
       return is.ajouterClient(client);
   }
   @PostMapping("ajouterCuisinier")
   public void ajouterCuisinier(@RequestBody Cuisinier cuisinier) {
       is.ajouterCuisinier(cuisinier);
   }
   @PostMapping("ajouterPlatAffecterClientEtCuisinier")
   public void ajouterPlatAffecterClientEtCuisinier(@RequestBody Plat plat, @RequestParam Integer idClient,@RequestParam Integer idCuisinier) {
       is.ajouterPlatAffecterClientEtCuisinier(plat, idClient, idCuisinier);
   }
    @GetMapping("AfficherListePlatsParClient")
    public List<Plat> AfficherListePlatsParClient(@RequestParam String nom,@RequestParam String prenom) {
        return is.AfficherListePlatsParClient(nom, prenom);
    }
    @GetMapping("MontantApayerParClient")
    public float MontantApayerParClient(@RequestParam Integer idClient) {
       return is.MontantApayerParClient(idClient);
    }
    @PutMapping("ModifierImc")
    public void ModifierImc(@RequestParam Integer idClient) {
         is.ModifierImc(idClient);
    }


    }
