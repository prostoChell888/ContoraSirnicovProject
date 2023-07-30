package ru.sirniky.back.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.sirniky.back.entity.test.AssignedTest;

import java.util.List;

@Entity
@Table(name = "student_group")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "group_name")
    private String name;

    @Column(name = "course")
    private Integer course;

    @ManyToMany
    protected List<AssignedTest> assignedTests;

}
