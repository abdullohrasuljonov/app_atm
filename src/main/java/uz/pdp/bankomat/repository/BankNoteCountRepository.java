package uz.pdp.bankomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankomat.entity.Banknotes;

public interface BankNoteCountRepository extends JpaRepository<Banknotes,Integer> {
}
