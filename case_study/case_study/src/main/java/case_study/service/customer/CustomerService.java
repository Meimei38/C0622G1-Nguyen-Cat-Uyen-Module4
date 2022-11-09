package case_study.service.customer;

import case_study.model.customer.Customer;
import case_study.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomersExist(Pageable pageable, String name, String email, String customerType) {
        return customerRepository.findAllCustomersExist(pageable, name, email, customerType);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerRepository.findByIdAndIsPresent(id, 1);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAllCustomer();
    }
}
