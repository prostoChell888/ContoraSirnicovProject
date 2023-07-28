package ru.sirniky.back.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sirniky.back.entity.PersonInfo;
import ru.sirniky.back.entity.Role;
import ru.sirniky.back.exeption.EntityNotFound;
import ru.sirniky.back.repositrory.StudentRepository;
import ru.sirniky.back.repositrory.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final StudentRepository studentRepository; // Здесь UserRepository представляет ваш репозиторий для доступа к данным пользователей.
    private final TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<PersonInfo> person = studentRepository.findByEmail(email);

        PersonInfo personValue = person.orElseGet(() -> teacherRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFound("entity not found")));

        // Здесь вы создаете объект UserDetails, который содержит информацию о пользователе, включая имя, пароль и роли.
        return new User(
                personValue.getFullName(),
                personValue.getPassword(),
                getAuthorities(personValue.getRoles())
        );

    }
    private List<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())) // Важно, чтобы имена ролей начинались с "ROLE_"
                .toList();
    }
}
