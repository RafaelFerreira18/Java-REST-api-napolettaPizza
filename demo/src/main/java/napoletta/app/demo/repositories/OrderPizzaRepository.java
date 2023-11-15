package napoletta.app.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import napoletta.app.demo.models.OrderPizza;
import napoletta.app.demo.models.OrderPizzaPk;

public interface OrderPizzaRepository extends CrudRepository<OrderPizza, OrderPizzaPk> {
}