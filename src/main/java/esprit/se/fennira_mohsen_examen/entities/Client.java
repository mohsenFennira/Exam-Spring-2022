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
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idClient;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Imc imc;
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Plat> platList;

}
