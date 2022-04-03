package uz.pdp.bankomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankomat.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
