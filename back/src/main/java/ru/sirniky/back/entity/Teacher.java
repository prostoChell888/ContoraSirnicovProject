package ru.sirniky.back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.sirniky.back.entity.test.AssignedTest;

import java.util.List;

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
    @OneToMany
    private List<AssignedTest> assignedTest;
}
