package springbootbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import springbootbackend.serialisers.CustomCardDeserialiser;
import springbootbackend.serialisers.CustomDetailsSerialiser;

import java.math.BigDecimal;
import java.util.List;

/**
 * '@IdClass' Annotation is used to define the composite keys in tables.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(DetailsId.class)
@ToString
@EqualsAndHashCode()
@Table(name="Details")
@JsonSerialize(using= CustomDetailsSerialiser.class)
@JsonDeserialize(using = CustomCardDeserialiser.class)
public class Details {

    @Id
    @Column(name = "spcName")
    private String spcNameComposite;
    @Id
    @Column(name = "pwrType")
    private String pwrTypeComposite;

    @Id
    @Column(name = "buyFrom", nullable = false)
    private String buyFrom;
    @Id
    @Column(name = "shopName", nullable = false)
    private String shopName;
    @Id
    @Column(name = "buyPrice", nullable = false)
    private BigDecimal buyPrice;
    @Column(name = "highSellPrice", nullable = false)
    private BigDecimal highSellPrice;
//    @Id
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    //    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="spcName", referencedColumnName = "spcName",
    insertable = false, updatable = false)
//    @JoinColumn(name="spcName")
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
    private Species spcName;

    //    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pwrType", referencedColumnName = "pwrType",
    insertable = false, updatable = false)
//    @JoinColumn(name="pwrType")
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
    private PowerType pwrType;

    @JsonIgnore
    // If there is no @JsonIgnore here, 'empty' is treated as a variable to be serialised
    public boolean isEmpty() {
        if ((this.buyFrom == null) || (this.quantity == 0) || (this.shopName == null) || (this.buyPrice == null) || (this.highSellPrice == null) || (this.spcName == null) || (this.pwrType == null)) {
            return true;
        }
        return false;
    }


}
