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
public class User {
    @Id
    private String uid;
    private String firstName;
    private String lastName;
    private String city;
    @ManyToOne
    private Role role;
    @OneToMany
    private List<Payment> payments;



}
