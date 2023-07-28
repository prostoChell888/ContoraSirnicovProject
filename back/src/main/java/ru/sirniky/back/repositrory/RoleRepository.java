package ru.sirniky.back.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sirniky.back.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
