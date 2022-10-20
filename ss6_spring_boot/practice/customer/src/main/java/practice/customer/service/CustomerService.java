package practice.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import practice.customer.model.Customer;
import practice.customer.repository.ICustomerRepository;

import java.util.List;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    @Modifying
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Modifying
    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}