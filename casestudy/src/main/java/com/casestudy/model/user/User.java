package com.casestudy.model.user;

import com.casestudy.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @JoinColumn(unique = true)
    private String userName;

    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;


    public User() {
    }

    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public User(Long userId, String username, String password) {
        this.userId = userId;
        this.userName = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
