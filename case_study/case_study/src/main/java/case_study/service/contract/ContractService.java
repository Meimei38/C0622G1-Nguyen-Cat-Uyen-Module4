package case_study.service.contract;

import case_study.dto.contract.IContractPageDto;
import case_study.model.contract.Contract;
import case_study.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;

    @Override
    public Page<IContractPageDto> findContractExist(Pageable pageable) {
        return contractRepository.findContractExist(pageable);
    }

}
