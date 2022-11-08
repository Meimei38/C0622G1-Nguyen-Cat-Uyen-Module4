package case_study.repository.facility;

import case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select * from Facility where is_present = 1 " +
            "and name like %:searchName% " +
            "and facility_type_id like %:searchFacilityType%", nativeQuery = true)
    Page<Facility> findFacilityExist(Pageable pageable, @Param("searchName") String searchName, @Param("searchFacilityType") String searchFacilityType);

    Facility findByIdAndIsPresent(Integer id, Integer isPresent);
}
