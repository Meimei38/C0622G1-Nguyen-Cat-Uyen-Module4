package case_study.repository.contract;

import case_study.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    @Query(value = "select * from attach_facility where is_present = 1", nativeQuery = true)
    List<AttachFacility> getAllAttachFacility();
}
