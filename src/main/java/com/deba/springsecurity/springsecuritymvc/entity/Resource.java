package com.deba.springsecurity.springsecuritymvc.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.util.Set;
//import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "res_id", length = 30)
    private int id;

    @Column(name = "res_name")
    @Length(min = 1)
   // @NotEmpty(message = "User name should be greater than 1 character")
    private String name;

    @Column(name = "res_lastname")
    @Length(min = 1)
    // @NotEmpty(message = "User name should be greater than 1 character")
    private String lastName;

    @Column(name = "res_email")
    @Length(min = 2)
   // @NotEmpty(message = "department must be greater than 2 characters")
    private String email;

    @Length(min = 2)
   // @NotEmpty(message = "email ID must be greater than 2 characters")
    @Column(name = "res_username")
    private String username;

    @Length(min = 2)
    // @NotEmpty(message = "email ID must be greater than 2 characters")
    @Column(name = "res_password")
    private String password;

    @Column(name = "res_state")
    private Boolean state;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "res_role", joinColumns = @JoinColumn(name = "res_id"), inverseJoinColumns=@JoinColumn (name="role_id"))
    private Set<Role> role;
}
