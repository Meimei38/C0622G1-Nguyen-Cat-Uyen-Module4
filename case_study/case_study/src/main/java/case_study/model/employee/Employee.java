package case_study.model.employee;

import case_study.model.contract.Contract;
import case_study.model.security.User;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "DATETIME")
    private String dateOfBirth;
    private String idCard;
    private Double salary;
    private String phoneNumber;
    private String email;
    private String address;
    @Column(columnDefinition = "bit default 1")
    private Integer isPresent;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;
    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contractSet;

    public Employee() {
    }

    public Employee(Integer id, String name, String dateOfBirth, String idCard, Double salary, String phoneNumber, String email, String address, Integer isPresent, Position position, Division division, EducationDegree educationDegree, User user) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.isPresent = isPresent;
        this.position = position;
        this.division = division;
        this.educationDegree = educationDegree;
        this.user = user;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Integer isPresent) {
        this.isPresent = isPresent;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
