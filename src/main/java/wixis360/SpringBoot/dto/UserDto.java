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
    private String UID;
    private String FirstName;
    private String LastName;
    private String City;
    private RoleDto roleDto;

}
