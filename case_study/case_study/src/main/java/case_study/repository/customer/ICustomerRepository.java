package case_study.repository.customer;

import case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;



@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from Customer where is_present = 1 " +
            "and name like %:nameSearch% " +
            "and email like %:emailSearch% " +
            "and customer_type_id like %:customerTypeSearch%", nativeQuery = true)
    Page<Customer> findAllCustomersExist(Pageable pageable, @Param("nameSearch") String name, @Param("emailSearch") String email,@Param("customerTypeSearch") String customerType);

    Customer findByIdAndIsPresent(Integer id, Integer status);


}
