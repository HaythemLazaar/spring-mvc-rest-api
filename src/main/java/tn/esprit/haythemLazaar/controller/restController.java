package tn.esprit.haythemLazaar.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import tn.esprit.haythemLazaar.entities.*;
import tn.esprit.haythemLazaar.services.InterfaceService;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class restController {
// Injection des Services
    InterfaceService service;
    
// API Routes
    @PostMapping("/addBank")
    public Bank ajouterBank(@RequestBody Bank bank) {
        return service.ajouterBank(bank);
    }

    @PostMapping("/addCompteAgence/{agenceBank}")
    Compte ajouterCompteEtAffecterAAgence(
        @RequestBody Compte compte,
        @PathVariable("agenceBank") String agenceBank
        ){
        return service.ajouterCompteEtAffecterAAgence(compte, agenceBank);
    }

    @PostMapping("/addVirement")
    String ajouterVirement(Transaction transaction){
        return service.ajouterVirement(transaction);
    }

    @PostMapping("/addRetrait")
    String ajouterRetrait(Transaction transaction){
        return service.ajouterRetrait(transaction);
    }

    @PostMapping("/addVersement")
    String ajouterVersement(Transaction transaction){
        return service.ajouterVersement(transaction);
    }

}
