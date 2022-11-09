package case_study.service.contract;

import case_study.model.contract.AttachFacility;
import case_study.repository.contract.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachService{
    @Autowired
    IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> getAllAttachFacility() {
        return attachFacilityRepository.getAllAttachFacility();
    }
}
