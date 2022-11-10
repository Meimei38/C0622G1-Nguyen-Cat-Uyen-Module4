package case_study.service.contract;

import case_study.dto.contract.IAttachContractDetailDto;
import case_study.model.contract.Contract;
import case_study.model.contract.ContractDetail;

import java.util.List;
import java.util.Map;

public interface IContractDetailService {
    List<IAttachContractDetailDto> findAttachContractDetail(Integer id);

    void saveDetail(Contract contract,List<Integer> attachFacility);

    void save(ContractDetail contractDetail);
}
