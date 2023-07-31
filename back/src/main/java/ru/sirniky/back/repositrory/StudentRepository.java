package ru.sirniky.back.repositrory;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sirniky.back.entity.PersonInfo;
import ru.sirniky.back.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<PersonInfo> findByEmail(String email);




    Optional<PersonInfo> findByEmailAndPassword(String email, String password);
}
