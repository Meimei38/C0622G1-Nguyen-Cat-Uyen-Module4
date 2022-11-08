package case_study.service.customer;

import case_study.model.customer.CustomerType;
import case_study.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService{
    @Autowired
    ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> getCustomerTypes() {
        return customerTypeRepository.findAll();
    }
}
