package tn.esprit.haythemLazaar.services;

import java.util.*;
import java.util.stream.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import tn.esprit.haythemLazaar.entities.*;
import tn.esprit.haythemLazaar.repository.*;


@AllArgsConstructor
@Service
public class ServiceImp implements InterfaceService{
// Injection des Repos
    PersonnelRepository personnelRepository;

// Methodes du service

// Execution chaque 60s
    //@Scheduled(fixedRate = 60000)
    //@Override
}
