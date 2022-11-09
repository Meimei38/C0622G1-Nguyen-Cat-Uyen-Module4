package case_study.service.employee;

import case_study.model.employee.Employee;
import case_study.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAllEmployee();
    }
}
