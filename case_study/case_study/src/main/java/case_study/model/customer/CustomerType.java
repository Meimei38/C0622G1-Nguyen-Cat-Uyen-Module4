package case_study.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "bit default 1")
    private Integer isPresent;
    @JsonBackReference
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customerSet;

    public CustomerType() {
    }

    public CustomerType(Integer id, String name, Integer isPresent, Set<Customer> customerSet) {
        this.id = id;
        this.name = name;
        this.isPresent = isPresent;
        this.customerSet = customerSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Integer isPresent) {
        this.isPresent = isPresent;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
