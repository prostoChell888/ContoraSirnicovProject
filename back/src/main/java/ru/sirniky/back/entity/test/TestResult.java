package ru.sirniky.back.entity.test;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sirniky.back.entity.Student;
import ru.sirniky.back.entity.Teacher;
import ru.sirniky.back.enums.ResultStatus;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test test;

    private ResultStatus status = ResultStatus.RESOLVED;

    private int scores;
    @ManyToOne
    @JoinColumn(name = "assignedTest_id", referencedColumnName = "id")
    private AssignedTest assignedTest;

    @Column(name = "test_completed_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp testCompletedTime;

}
