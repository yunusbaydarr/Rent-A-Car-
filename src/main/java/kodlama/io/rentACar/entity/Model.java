package kodlama.io.rentACar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="models")
public class Model {


        @Column(name = "id")
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @Column(name = "name")
        private String name;

        @ManyToOne
        @JoinColumn(name = "brand_id")
       private Brand brand;

        @OneToMany(mappedBy = "model")
        private List<Car> cars;
}
