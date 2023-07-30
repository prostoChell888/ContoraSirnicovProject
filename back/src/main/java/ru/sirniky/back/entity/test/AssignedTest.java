package ru.sirniky.back.entity.test;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sirniky.back.entity.Discipline;
import ru.sirniky.back.entity.Group;
import ru.sirniky.back.entity.Teacher;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "assigned_test")
public class AssignedTest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test test;
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;
    @ManyToMany
    private List<Group> groups;
    @OneToMany
    private List<TestResult> testResults;

    @Column(name = "end_of_test_uime")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp endOfTestTime;



}
