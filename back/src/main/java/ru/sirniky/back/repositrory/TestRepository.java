package ru.sirniky.back.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.test.Test;

public interface TestRepository extends JpaRepository<Test, Long> {


}
