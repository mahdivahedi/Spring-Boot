package tacos.dto;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="taco_Order")
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Date placedAt;

    @NotBlank(message="Name is required")
    private String name;

    @ManyToOne
    private User user;

    @NotBlank(message="street is required")
    private String street;

    @NotBlank(message="city is required")
    private String city;

    @NotBlank(message="state is required")
    private String state;

    @NotBlank(message="zip is required")
    private String zip;

    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([/])([1-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }
    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

}
