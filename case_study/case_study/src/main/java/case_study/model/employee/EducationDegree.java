package case_study.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "bit default 1")
    private Integer isPresent;
    @OneToMany(mappedBy = "educationDegree")
    Set<Employee>employees;

    public EducationDegree() {
    }

    public EducationDegree(Integer id, String name, Integer isPresent, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.isPresent = isPresent;
        this.employees = employees;
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
