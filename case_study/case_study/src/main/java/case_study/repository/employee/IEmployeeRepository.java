package case_study.repository.employee;

import case_study.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from Employee where is_present = 1", nativeQuery = true)
    List<Employee> findAllEmployee();
}
