package springbootbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class DetailsId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String spcNameComposite;
    private String pwrTypeComposite;
    private String buyFrom;
    private String shopName;
    private BigDecimal buyPrice;
//    private int quantity;
}
