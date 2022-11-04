package case_study.model.security;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;
    @Column(columnDefinition = "bit default 1")
    private Integer isPresent;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(Integer roleId, String roleName, Integer isPresent, Set<User> users) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.isPresent = isPresent;
        this.users = users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Integer isPresent) {
        this.isPresent = isPresent;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
