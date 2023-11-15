package napoletta.app.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class OrderPizza {

    @EmbeddedId
    @JsonIgnore
    private OrderPizzaPk pk;


    public OrderPizza(Order order, Pizza pizza) {
        pk = new OrderPizzaPk();
        pk.setOrder(order);
        pk.setPizza(pizza);
    }

    /**
     * @return OrderPizzaPk return the pk
     */
    public OrderPizzaPk getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(OrderPizzaPk pk) {
        this.pk = pk;
    }


    @Transient
    public Pizza getPizza() {
        return this.pk.getPizza();
    }

}