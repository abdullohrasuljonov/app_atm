package uz.pdp.bankomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankomat.entity.Operation;
import uz.pdp.bankomat.entity.enums.ATMOperationType;

import java.time.LocalDate;
import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Integer> {
    List<Operation> findAllByAtmId(Integer atm_id);
    List<Operation> findAllByAtmIdAndDateAndOperationType(Integer atm_id, LocalDate date, ATMOperationType operationType);
}
