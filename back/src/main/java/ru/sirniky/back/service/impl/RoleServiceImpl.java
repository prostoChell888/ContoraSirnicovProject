package ru.sirniky.back.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sirniky.back.entity.Role;
import ru.sirniky.back.exeption.EntityNotFound;
import ru.sirniky.back.repositrory.RoleRepository;
import ru.sirniky.back.service.RoleService;
import ru.sirniky.back.util.RoleEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public void initRoles() {
        List<Role> roleList = new ArrayList<>();

        Arrays.stream(RoleEnum.values())
                .forEach(role -> roleList.add(Role.builder()
                        .name(role.name())
                        .build())
                );

        roleRepository.saveAll(roleList);
    }

    @Override
    public Role getRoleByName(RoleEnum role) {
        return roleRepository.findByName(role.name())
                .orElseThrow(() -> new EntityNotFound("role with name " + role.name() + " not found"));
    }
}
