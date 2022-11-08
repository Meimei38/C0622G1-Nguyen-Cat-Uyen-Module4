package case_study.service.facility;

import case_study.model.facility.Facility;

import java.util.List;

public interface IFacilityService {
    void save(Facility facility);

    void checkFacility(Facility facility);

    List<Facility> findFacilityExist();
}
