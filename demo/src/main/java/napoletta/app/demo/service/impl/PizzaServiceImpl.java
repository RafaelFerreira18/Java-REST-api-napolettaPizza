// package napoletta.app.demo.service.impl;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;

// import napoletta.app.demo.models.Pizza;
// import napoletta.app.demo.models.PizzaRepository;
// import napoletta.app.demo.service.PizzaService;

// public class PizzaServiceImpl implements PizzaService{
//     @Autowired
// 	private PizzaRepository pizzaRepository;
	
// 	@Override
// 	public Iterable<Pizza> searchAll() {
// 		return pizzaRepository.findAll();
// 	}

// 	@Override
// 	public Pizza searchById(Long id) {
// 		Optional<Pizza> pizza = pizzaRepository.findById(id);
// 		return pizza.get();
// 	}

// 	@Override
// 	public void update(Long id, Pizza pizza) {
// 		Optional<Pizza> pizzaBd = pizzaRepository.findById(id);
//         if(pizzaBd.isPresent()){
//             pizzaRepository.save(pizza);
//         }
// 	}

// 	@Override
// 	public void delete(Long id) {
// 		pizzaRepository.deleteById(id);
// 	}

//     @Override
//     public void insert(Pizza pizza) {
//         pizzaRepository.save(pizza);
//     }
// }
