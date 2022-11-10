package case_study.service.contract;

import case_study.dto.contract.IAttachContractDetailDto;
import case_study.model.contract.AttachFacility;
import case_study.model.contract.Contract;
import case_study.model.contract.ContractDetail;
import case_study.repository.contract.IAttachFacilityRepository;
import case_study.repository.contract.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContractDetailService implements IContractDetailService{
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Autowired
    IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<IAttachContractDetailDto> findAttachContractDetail(Integer id) {
        return contractDetailRepository.findAttachContractDetail(id);
    }

    @Override
    public void saveDetail(Contract contract, List<Integer> attachFacility) {
        for (int i = 0; i < attachFacility.size(); i+=2) {
            for (int j = 1; j <attachFacility.size() ; j+=2) {
                Integer idAttach = attachFacility.get(i);
                Integer quantity = attachFacility.get(j);
                AttachFacility attach = attachFacilityRepository.findById(idAttach).get();
                ContractDetail contractDetail = new ContractDetail(quantity,1,attach,contract);
                contractDetailRepository.save(contractDetail);
            }
        }






    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
