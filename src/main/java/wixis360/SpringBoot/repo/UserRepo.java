package wixis360.SpringBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import wixis360.SpringBoot.entity.User;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/
public interface UserRepo extends JpaRepository<User , String> {
}
