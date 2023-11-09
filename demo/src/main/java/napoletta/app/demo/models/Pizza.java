package napoletta.app.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id")
    private Long id;

    @Column(nullable = false)
    private String pizzaName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String pizzaImgUrl;
    

    /**
     * @return Integer return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the pizzaName
     */
    public String getPizzaName() {
        return pizzaName;
    }

    /**
     * @param pizzaName the pizzaName to set
     */
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Integer return the price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * @return String return the pizzaImgUrl
     */
    public String getPizzaImgUrl() {
        return pizzaImgUrl;
    }

    /**
     * @param pizzaImgUrl the pizzaImgUrl to set
     */
    public void setPizzaImgUrl(String pizzaImgUrl) {
        this.pizzaImgUrl = pizzaImgUrl;
    }

}
