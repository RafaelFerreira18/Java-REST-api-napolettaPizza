package napoletta.app.demo.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import napoletta.app.demo.models.OrderPizza;
import napoletta.app.demo.repositories.OrderPizzaRepository;

@Service
@Transactional
public class OrderPizzaService{

    private OrderPizzaRepository orderPizzaRepository;

    public OrderPizzaService(OrderPizzaRepository orderPizzaRepository) {
        this.orderPizzaRepository = orderPizzaRepository;
    }
    public OrderPizza create(OrderPizza orderPizza) {
        return this.orderPizzaRepository.save(orderPizza);
    }
}
