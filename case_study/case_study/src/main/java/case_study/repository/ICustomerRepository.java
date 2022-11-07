package case_study.repository;

import case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;



@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from Customer where is_present = 1", nativeQuery = true)
    Page<Customer> findAllCustomersExist(Pageable pageable);

    Customer findByIdAndIsPresent(Integer id, Integer status);


}
