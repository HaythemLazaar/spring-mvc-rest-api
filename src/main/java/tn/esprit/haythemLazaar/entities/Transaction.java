package tn.esprit.haythemLazaar.entities;

import java.util.*;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
@Table(name = "Transaction")
@Getter
@Setter
public class Transaction {
// Colonnes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private long idTransaction;
    private Double montant;
// Date
    @Temporal(TemporalType.DATE)
    private Date dateTransaction;
// ENUM
    private TypeTransaction type;

// Associations
    @ManyToOne(cascade = CascadeType.ALL)
    Compte expediteur;

    @ManyToOne(cascade = CascadeType.ALL)
    Compte destinataire;
}
