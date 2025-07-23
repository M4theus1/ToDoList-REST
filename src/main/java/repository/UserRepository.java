package repository;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//o extends jparepository significa <Entidade, TipoDaChavePrimaria>
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
