package ru.sirniky.back.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sirniky.back.entity.Student;
import ru.sirniky.back.entity.test.AssignedTest;

import java.util.List;


@Repository
public interface AssignedTestRepository extends JpaRepository<AssignedTest, Long> {

    List<AssignedTest> getAssignedTestByStudents(Student student);


}


