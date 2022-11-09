package case_study.repository.contract;

import case_study.dto.contract.IContractPageDto;
import case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "SELECT f.name AS facilityName," +
            "                   c.name AS customerName," +
            "            e.name AS employeeName," +
            "            ct.id AS id," +
            "            ct.start_date AS startDate," +
            "            ct.end_date AS endDate," +
            "            ct.deposit,\n" +
            "            ((IFNULL(SUM(cd.quantity * af.cost), 0) + f.cost)) AS total " +
            "FROM " +
            "             contract ct" +
            "             LEFT JOIN " +
            "             facility f " +
            "ON ct.facility_id = f.id " +
            "             LEFT JOIN " +
            "             contract_detail cd ON ct.id = cd.contract_id " +
            "             LEFT JOIN " +
            "             attach_facility af ON cd.attach_facility_id = af.id " +
            "             LEFT JOIN " +
            "            customer c ON ct.customer_id = c.id " +
           "            LEFT JOIN " +
            "             employee e ON ct.employee_id = e.id " +
            "WHERE ct.is_present = 1 " +
            "GROUP BY ct.id", nativeQuery = true,
    countQuery = "SELECT f.name AS facilityName," +
            "                   c.name AS customerName," +
            "            e.name AS employeeName," +
            "            ct.id AS id," +
            "            ct.start_date AS startDate," +
            "            ct.end_date AS endDate," +
            "            ct.deposit,\n" +
            "            ((IFNULL(SUM(cd.quantity * af.cost), 0) + f.cost)) AS total " +
            "FROM " +
            "             contract ct" +
            "             LEFT JOIN " +
            "             facility f " +
            "ON ct.facility_id = f.id " +
            "             LEFT JOIN " +
            "             contract_detail cd ON ct.id = cd.contract_id " +
            "             LEFT JOIN " +
            "             attach_facility af ON cd.attach_facility_id = af.id " +
            "             LEFT JOIN " +
            "            customer c ON ct.customer_id = c.id " +
            "            LEFT JOIN " +
            "             employee e ON ct.employee_id = e.id " +
            "WHERE ct.is_present = 1 " +
            "GROUP BY ct.id")
   Page<IContractPageDto> findContractExist(Pageable pageable);

}
