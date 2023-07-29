package ru.sirniky.back.repositrores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long> {


}
