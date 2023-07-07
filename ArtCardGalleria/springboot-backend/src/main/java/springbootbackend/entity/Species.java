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
@Entity
@Table(name="PokemonSpecies")
public class Species {

    //@JsonSerialize(using=CustomCarSerializer.class)
//when this object is sent out to my user webpage to show, it uses the serialiser class
    @Id
    @Column(name = "spcName", nullable = false)
    private String spcName;

    @Column(name = "spcBackground", nullable = false)
    private String spcBackground;

    @Column(name = "spcType", nullable = false)
    private String spcType;


    //    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy="spcName") //bidrectional one to many
    private List<Details> detailsList;
}
