package uz.pdp.bankomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankomat.entity.ATM;

public interface ATMRepository extends JpaRepository<ATM,Integer> {
}
