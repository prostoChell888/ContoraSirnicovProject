package ru.sirniky.back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.sirniky.back.util.RoleEnum;

import java.util.List;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class PersonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    @Email
    private String email;

    @ManyToMany
    @JoinColumn(name = "role_id")
    private List<Role> roles;

    public void addRole(RoleEnum role) {

        Role roleEntity = Role.builder()
                        .name(role.name())
                                .build();

        roles.add(roleEntity);
    }
}
