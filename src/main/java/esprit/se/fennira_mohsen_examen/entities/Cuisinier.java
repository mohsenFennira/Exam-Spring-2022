package esprit.se.fennira_mohsen_examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Cuisinier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idCuisinier;
    private String nom;
    private String prenom;

    @ManyToMany(mappedBy = "cuisinierList")
    private List<Plat> plats;
}
