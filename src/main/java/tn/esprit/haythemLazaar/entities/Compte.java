package tn.esprit.haythemLazaar.entities;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
@Table(name = "Compte")
@Getter
@Setter
public class Compte {
// Colonnes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Compte")
    private long idCompte;
    private long code;
    private Double solde;

// ENUM
    private TypeCompte type;

// Associations
}
