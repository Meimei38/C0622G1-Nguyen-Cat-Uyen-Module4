package case_study.dto.contract;

import case_study.model.contract.ContractDetail;
import case_study.model.customer.Customer;
import case_study.model.employee.Employee;
import case_study.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContractDto {
    private Integer id;
    private String startDate;
    private String endDate;
    private Double deposit;
    private Integer isPresent = 1;
    private Employee employee;
    private Set<ContractDetail> contractDetails;
    private Customer customer;
    private Facility facility;
    private List<Integer> attachFacility;

    public ContractDto() {
    }

    public ContractDto(Integer id, String startDate, String endDate, Double deposit, Integer isPresent, Employee employee, Set<ContractDetail> contractDetails, Customer customer, Facility facility, List<Integer> attachFacility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.isPresent = isPresent;
        this.employee = employee;
        this.contractDetails = contractDetails;
        this.customer = customer;
        this.facility = facility;
        this.attachFacility = attachFacility;
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

    public List<Integer> getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(List<Integer> attachFacility) {
        this.attachFacility = attachFacility;
    }
}
