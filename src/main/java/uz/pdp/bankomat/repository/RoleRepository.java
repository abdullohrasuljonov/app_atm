package uz.pdp.bankomat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.bankomat.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
