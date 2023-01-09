package tn.esprit.haythemLazaar.services;

import java.util.*;
import tn.esprit.haythemLazaar.entities.*;

public interface InterfaceService {
    Bank ajouterBank(Bank bank);
    Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank);
    String ajouterVirement(Transaction transaction);
    String ajouterRetrait(Transaction transaction);
    String ajouterVersement(Transaction transaction);
    void getAllTransactionByDate();
    List<Transaction> getAllTransactionByBankId(Long idBank);
    List<Transaction> getAllTransactionByTypeAndCompte(TypeTransaction type, long idCompte);
}
