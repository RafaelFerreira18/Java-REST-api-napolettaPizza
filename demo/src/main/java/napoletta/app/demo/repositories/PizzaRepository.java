package napoletta.app.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import napoletta.app.demo.models.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long>{
    boolean existsByPizzaName(String pizzaName);
}
