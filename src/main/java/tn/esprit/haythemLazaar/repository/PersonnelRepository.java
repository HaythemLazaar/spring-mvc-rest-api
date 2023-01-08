package tn.esprit.haythemLazaar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.haythemLazaar.entities.*;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long>{
}
