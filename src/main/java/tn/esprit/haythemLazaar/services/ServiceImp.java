package tn.esprit.haythemLazaar.services;

import java.time.Instant;
import java.util.*;
import java.util.stream.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import tn.esprit.haythemLazaar.entities.*;
import tn.esprit.haythemLazaar.repository.*;


@AllArgsConstructor
@Service
public class ServiceImp implements InterfaceService{
// Injection des Repos
    CompteRepository compteRepository;
    BankRepository bankRepository;
    TransactionRepository transactionRepository;
    
// Methodes du service
@Override
    public Bank ajouterBank(Bank bank) {
        return bankRepository.save(bank);
    }
    @Override
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank) {
        compteRepository.save(compte);
        Bank bank = bankRepository.findAll().stream().filter(b -> b.getAgence() == agenceBank).findFirst().orElse(null);
        Set<Compte> comptes = new HashSet<Compte>();
        if(bank.getComptes().size() > 0){
            comptes = bank.getComptes();
            comptes.add(compte);
        }else{
            comptes.add(compte);
        }
        bank.setComptes(comptes);
        return compte;
    }
    @Override
    public String ajouterVirement(Transaction transaction) {
        String rep = "";
        if(transaction.getType() == TypeTransaction.VIREMENT){
            if(transaction.getExpediteur().getType() == TypeCompte.EPARGNE){
                rep = "On ne peut pas faire un virement a partir d'un compte epargne";
            }else{
                if(transaction.getExpediteur().getSolde() < (transaction.getMontant()+3)){
                    rep = "One ne peut pas faire un virement : Solde insiffisant";
                }else{
                    rep = "VIREMENT de " + transaction.getMontant() + "DT" + " de compte " + transaction.getExpediteur().getCode() 
                        + " vers le compte" + transaction.getDestinataire().getCode() + "approuve avec succes.";
                    transaction.getExpediteur().setSolde(transaction.getExpediteur().getSolde() - transaction.getMontant() - 3);
                    transaction.getDestinataire().setSolde(transaction.getDestinataire().getSolde() + transaction.getMontant());
                }
            }
        }
        return rep;
    }
    @Override
    public String ajouterRetrait(Transaction transaction) {
        String rep = "";
        if(transaction.getType() == TypeTransaction.RETRAIT){
            if(transaction.getExpediteur().getSolde() > (transaction.getMontant() + 2)){
                rep = "One ne peut pas faire un retrait : Solde insiffisant";
            }else{
                rep = "RETRAIT de " + transaction.getMontant() + "DT de compte " + transaction.getExpediteur().getCode() 
                    + "approuve avec succes";
                    transaction.getExpediteur().setSolde(transaction.getExpediteur().getSolde() - transaction.getMontant() - 2);
            }
        }
        return rep;
    }
    @Override
    public String ajouterVersement(Transaction transaction) {
        String rep = "";
        if(transaction.getType() == TypeTransaction.VERSEMENT){
            if(transaction.getDestinataire().getType() != TypeCompte.EPARGNE){
                transaction.getDestinataire().setSolde(transaction.getDestinataire().getSolde() + transaction.getMontant() - 2);
                rep = "VERSEMENT de " + transaction.getMontant() + "DT de compte " + transaction.getDestinataire().getCode() 
                    + "approuve avec succes";
            }
        }
        return rep;
    }

    @Scheduled(fixedRate = 30000)
    @Override
    public void getAllTransactionByDate() {
        Date today = new Date();
        transactionRepository.findAll().stream()
            .forEach(t -> {
                if(t.getDateTransaction().equals(today)) System.out.println(t.toString());
            });
    }
    @Override
    public List<Transaction> getAllTransactionByBankId(Long idBank) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<Transaction> getAllTransactionByTypeAndCompte(TypeTransaction type, long idCompte) {
        // TODO Auto-generated method stub
        return null;
    }

}
