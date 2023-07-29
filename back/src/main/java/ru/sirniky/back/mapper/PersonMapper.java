package ru.sirniky.back.mapper;

import org.mapstruct.Mapper;
import ru.sirniky.back.dto.PersonWithRoleDto;
import ru.sirniky.back.entity.PersonInfo;
import ru.sirniky.back.entity.Role;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    default List<String> mapRoles(List<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .toList();
    }


    PersonWithRoleDto toWithRoleDto(PersonInfo personInfo);
}
