package napoletta.app.demo.dto;

import napoletta.app.demo.models.Pizza;

public class orderPizzaDto {
    private Pizza pizza;
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
