package case_study.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class ContractDetail {
    public ContractDetail(Integer quantity, Integer isPresent, AttachFacility attachFacility, Contract contract) {
        this.quantity = quantity;
        this.isPresent = isPresent;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private Integer quantity;
    @Column(columnDefinition = "bit default 1")
    private Integer isPresent;


    @ManyToOne
    @JoinColumn(name = "attach_facility_id", referencedColumnName = "id")
    private AttachFacility attachFacility;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(Integer id, Integer quantity, Integer isPresent, AttachFacility attachFacility, Contract contract) {
        this.id = id;
        this.quantity = quantity;
        this.isPresent = isPresent;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Integer isPresent) {
        this.isPresent = isPresent;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
