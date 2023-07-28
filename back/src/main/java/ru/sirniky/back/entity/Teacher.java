package ru.sirniky.back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Teacher extends PersonInfo{

    @Column(name = "rank")
    private String rank;

    @Column(name = "is_admin")
    private Boolean isAdmin;
}
