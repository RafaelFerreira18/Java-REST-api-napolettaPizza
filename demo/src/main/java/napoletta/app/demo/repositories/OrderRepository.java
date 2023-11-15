package napoletta.app.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import napoletta.app.demo.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
    
}
