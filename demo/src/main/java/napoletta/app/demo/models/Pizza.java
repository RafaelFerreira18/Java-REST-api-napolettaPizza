package napoletta.app.demo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="tab_pizza")
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
    private Double price;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "pizza_image",
        joinColumns = {
            @JoinColumn(name="pizza_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name="image_id")
        }
    )
    private ImageModel pizzaImage;
    

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
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return Set<ImageModel> return the pizzaImage
     */
    public ImageModel getPizzaImage() {
        return pizzaImage;
    }

    /**
     * @param pizzaImage the pizzaImage to set
     */
    public void setPizzaImage(ImageModel pizzaImage) {
        this.pizzaImage = pizzaImage;
    }

}
