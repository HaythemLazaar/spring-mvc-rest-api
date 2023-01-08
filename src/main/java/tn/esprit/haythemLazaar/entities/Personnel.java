package tn.esprit.haythemLazaar.entities;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
@Table(name = "Personnel")
@Getter
@Setter
public class Personnel {
// Colonnes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Personnel")
    private long idPersonnel;
    private String nom;
    private String prenom;
// Date
    @Temporal(TemporalType.DATE)
    private Date dateDerniereAffectation;
// ENUM
    private TypePersonnel typePersonnel;


// Associations

}
