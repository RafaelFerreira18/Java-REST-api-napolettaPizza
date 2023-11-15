package napoletta.app.demo.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.constraints.NotNull;
import napoletta.app.demo.dto.orderPizzaDto;
import napoletta.app.demo.models.Order;
import napoletta.app.demo.models.OrderPizza;
import napoletta.app.demo.models.OrderStatus;
import napoletta.app.demo.models.Pizza;
import napoletta.app.demo.service.OrderPizzaService;
import napoletta.app.demo.service.OrderService;
import napoletta.app.demo.service.PizzaService;

@RestController
@RequestMapping("orders")
public class OrderController {

    PizzaService pizzaService;
    OrderService orderService;
    OrderPizzaService orderPizzaService;

    public OrderController(PizzaService pizzaService, OrderService orderService, OrderPizzaService orderPizzaService) {
        this.pizzaService = pizzaService;
        this.orderService = orderService;
        this.orderPizzaService = orderPizzaService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Order> insert(@RequestBody Order order) {
		var orderCreated = orderService.create(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(orderCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(orderCreated);
	}
    @GetMapping("/{id}")
    public @NotNull Order getOrder(@PathVariable Long id) {
        return this.orderService.getOrder(id);
    }
}
