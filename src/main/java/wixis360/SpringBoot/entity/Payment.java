package wixis360.SpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    @Id
    private String pid;
    private String description;
    private String price;
    @ManyToOne
    private User user;
    @ManyToOne
    private VehicleType vehicleType;




}
