package ru.sirniky.back.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sirniky.back.entity.PersonInfo;
import ru.sirniky.back.entity.Teacher;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Optional<PersonInfo> findByEmail(String email);
}
