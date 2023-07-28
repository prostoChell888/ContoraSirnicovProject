package ru.sirniky.back.service;

import ru.sirniky.back.entity.Role;
import ru.sirniky.back.util.RoleEnum;

public interface RoleService {

    void initRoles();

    Role getRoleByName(RoleEnum role);
}
