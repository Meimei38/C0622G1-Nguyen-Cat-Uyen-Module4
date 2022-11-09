package case_study.service.contract;


import case_study.dto.contract.IContractPageDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<IContractPageDto> findContractExist(Pageable pageable);

}
