package napoletta.app.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import napoletta.app.demo.models.User;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
