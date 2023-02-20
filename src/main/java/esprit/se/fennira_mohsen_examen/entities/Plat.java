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
public class Plat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idPlat;
    private String label;
    private Float prix;
    private Float calories;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;
    @JsonIgnore
    @ManyToOne
    private Client client;
    @JsonIgnore
    @ManyToMany
    private List<Cuisinier> cuisinierList;
}
