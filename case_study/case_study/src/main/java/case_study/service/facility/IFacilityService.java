package case_study.service.facility;

import case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    void save(Facility facility);

    void checkFacility(Facility facility);


    Page<Facility> findFacilityExist(Pageable pageable, String searchName, String searchFacilityType);

    Facility findById(Integer id);

    List<Facility> findAllFacility();
}
