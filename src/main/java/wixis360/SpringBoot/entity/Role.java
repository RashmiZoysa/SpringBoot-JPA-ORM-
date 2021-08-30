package wixis360.SpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    private String rid;
    private String roleName;

}
