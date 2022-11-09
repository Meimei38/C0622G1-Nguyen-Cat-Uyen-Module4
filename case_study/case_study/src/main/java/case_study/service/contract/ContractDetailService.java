package case_study.service.contract;

import case_study.repository.contract.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService{
    @Autowired
    IContractDetailRepository contractDetailRepository;
}
