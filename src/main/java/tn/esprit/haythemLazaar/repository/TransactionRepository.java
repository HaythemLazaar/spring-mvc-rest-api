package tn.esprit.haythemLazaar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.haythemLazaar.entities.*;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
}
