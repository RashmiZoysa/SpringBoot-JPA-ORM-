package wixis360.SpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String uid;
    private String firstName;
    private String lastName;
    private String city;
    private RoleDto roleDto;

}
