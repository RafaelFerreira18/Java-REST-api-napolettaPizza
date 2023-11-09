// package napoletta.app.demo.models;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.MapsId;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;

// @Entity
// public class Cart {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "cart_id")
//     private long id;
//     @OneToOne
//     @MapsId
//     @JoinColumn(name = "id")
//     private User user;
//     @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
//     private Pizza[] pizza;

//     /**
//      * @return User return the user
//      */
//     public User getUser() {
//         return user;
//     }

//     /**
//      * @param user the user to set
//      */
//     public void setUser(User user) {
//         this.user = user;
//     }

//     /**
//      * @return Pizza[] return the pizza
//      */
//     public Pizza[] getPizza() {
//         return pizza;
//     }

//     /**
//      * @param pizza the pizza to set
//      */
//     public void setPizza(Pizza[] pizza) {
//         this.pizza = pizza;
//     }

// }
