package case_study.repository.contract;

import case_study.dto.contract.IAttachContractDetailDto;
import case_study.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
    @Query(value = "select attach_facility.name as nameDto, \n" +
            "            attach_facility.unit as unitDto, sum(ifnull(contract_detail.quantity, 0)) as quantityDto, \n" +
            "            attach_facility.status as statusDto, attach_facility.cost as costDto \n" +
            "            from contract_detail join attach_facility \n" +
            "            on contract_detail.attach_facility_id = attach_facility.id \n" +
            "            where contract_detail.contract_id =:id group by attach_facility.id", nativeQuery = true)
    List<IAttachContractDetailDto> findAttachContractDetail(@Param("id") Integer id);
}
