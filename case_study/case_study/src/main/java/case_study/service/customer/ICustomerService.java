package case_study.service.customer;

import case_study.model.customer.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Page<Customer> findAllCustomersExist(Pageable pageable, String name, String email, String customerType);

    Customer findCustomerById(Integer id);

    void save(Customer customer);

    void update(Customer customer);

    List<Customer> findAllCustomer();
}
