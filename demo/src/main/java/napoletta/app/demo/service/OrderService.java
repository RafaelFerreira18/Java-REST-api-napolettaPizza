package napoletta.app.demo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import napoletta.app.demo.models.Order;
import napoletta.app.demo.repositories.OrderRepository;

@Service
@Transactional
public class OrderService{

    @Autowired
    private OrderRepository orderRepository;

    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
	
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        return this.orderRepository.save(order);
    }

    public void update(Order order) {
        this.orderRepository.save(order);
    }

    public Order getOrder(Long id){
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}
