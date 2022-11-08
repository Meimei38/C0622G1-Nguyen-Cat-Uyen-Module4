package case_study.service.facility;

import case_study.model.facility.Facility;
import case_study.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService{
    @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void checkFacility(Facility facility) {
        switch (facility.getFacilityType().getId()){
            case 1:
                facility.setFacilityFree(null);
                break;
            case 2:
                facility.setPoolArea(null);
                facility.setFacilityFree(null);
                break;
            case 3:
                facility.setStandardRoom(null);
                facility.setDescriptionOtherConvenience(null);
                facility.setPoolArea(null);
                facility.setNumberOfFloors(null);
                break;
            default:
                facility.setStandardRoom(null);
                facility.setDescriptionOtherConvenience(null);
                facility.setPoolArea(null);
                facility.setNumberOfFloors(null);
                facility.setFacilityFree(null);

        }
    }

    @Override
    public Page<Facility> findFacilityExist(Pageable pageable, String searchName, String searchFacilityType) {
        return facilityRepository.findFacilityExist(pageable, searchName, searchFacilityType);
    }

    @Override
    public Facility findById(Integer id) {
        return facilityRepository.findByIdAndIsPresent(id, 1);
    }

}
