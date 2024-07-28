package pl.coderslab.szamadlaleniwych.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.szamadlaleniwych.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleById(int role);
}
