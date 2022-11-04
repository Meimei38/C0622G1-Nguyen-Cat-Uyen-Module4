package case_study.model.contract;

import javax.persistence.*;
import java.util.Set;
@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double cost;
    private String unit;
    private String status;
    @Column(columnDefinition = "bit default 1")
    private Integer isPresent;

    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetail;

    public AttachFacility() {
    }

    public AttachFacility(Integer id, String name, Double cost, String unit, String status, Integer isPresent, Set<ContractDetail> contractDetail) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.isPresent = isPresent;
        this.contractDetail = contractDetail;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Integer isPresent) {
        this.isPresent = isPresent;
    }

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }
}
