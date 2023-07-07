package springbootbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
@Table(name="PowerType")
public class PowerType {

    //@JsonSerialize(using=CustomCarSerializer.class)
//when this object is sent out to my user webpage to show, it uses the serialiser class
    @Id
    @Column(name = "pwrType", nullable = false)
    private String pwrType;
    @Column(name = "pwrTypeDescription", nullable = false)
    private String pwrTypeDescription;
    //    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy="pwrType") //bidrectional one to many
    private List<Details> detailsList;
}
