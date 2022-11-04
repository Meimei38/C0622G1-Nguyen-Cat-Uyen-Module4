package case_study.model.contract;

import case_study.model.customer.Customer;
import case_study.model.employee.Employee;
import case_study.model.facility.Facility;
import case_study.model.facility.FacilityType;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "DATETIME")
    private String startDate;
    @Column(columnDefinition = "DATETIME")
    private String endDate;
    private Double deposit;
    @Column(columnDefinition = "bit default 1")
    private Integer isPresent;
    @ManyToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name="facility_id", referencedColumnName = "id")
    private Facility facility;

    public Contract() {
    }

    public Contract(Integer id, String startDate, String endDate, Double deposit, Integer isPresent, Employee employee, Set<ContractDetail> contractDetails, Customer customer, Facility facility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.isPresent = isPresent;
        this.employee = employee;
        this.contractDetails = contractDetails;
        this.customer = customer;
        this.facility = facility;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Integer getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Integer isPresent) {
        this.isPresent = isPresent;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
