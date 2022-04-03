package uz.pdp.bankomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankomat.entity.Bank;

public interface BankRepository extends JpaRepository<Bank,Integer> {
}
