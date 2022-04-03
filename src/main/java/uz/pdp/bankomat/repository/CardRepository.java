package uz.pdp.bankomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankomat.entity.Card;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card,Integer> {

    List<Card> findAllByActiveIsFalse();

    Optional<Card> findByNumber(@Size(min = 16, max = 16) String number);

    List<Card> findAllByUserId(Integer user_id);
}
