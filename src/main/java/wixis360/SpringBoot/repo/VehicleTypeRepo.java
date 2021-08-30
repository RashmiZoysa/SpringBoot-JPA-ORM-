package wixis360.SpringBoot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import wixis360.SpringBoot.entity.VehicleType;

/**
 * @author : Rashmi De Zoysa
 * @Date :30-Aug-21
 **/
public interface VehicleTypeRepo extends JpaRepository<VehicleType , String> {
}
