package kodlama.io.rentACar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="cars")
public class Car {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "plate", unique = true)
    private String plate;

    @Column(name = "daily_price")
    private float dailyPrice;

    @Column(name="year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
