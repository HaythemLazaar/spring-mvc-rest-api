package tn.esprit.haythemLazaar.entities;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
@Table(name = "Bank")
@Getter
@Setter
public class Bank {
// Colonnes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Bank")
    private long idBank;
    private String nom;
    private String agence;
    private String adresse;

// Associations
    @OneToMany(cascade = CascadeType.ALL)
    Set<Compte> comptes;
}
