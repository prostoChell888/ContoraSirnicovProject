package ru.sirniky.back.config.appRunner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.sirniky.back.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AppInit implements ApplicationRunner {

    private final TeacherService teacherService;
    private final RoleService roleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        roleService.initRoles();

        List<AccountWithPasswordDto> accountList = new ArrayList<>();

        AccountWithPasswordDto accountDto = AccountWithPasswordDto.builder()
                .firstName("adminFirstName")
                .lastName("adminLastName")
                .email("admin@simbirsoft.com")
                .password("qwerty123")
                .role("ADMIN")
                .build();
        accountList.add(accountDto);

        accountDto = AccountWithPasswordDto.builder()
                .firstName("chipperFirstName")
                .lastName("chipperLastName")
                .email("chipper@simbirsoft.com")
                .password("qwerty123")
                .role("CHIPPER")
                .build();
        accountList.add(accountDto);

        accountDto = AccountWithPasswordDto.builder()
                .firstName("userFirstName")
                .lastName("userLastName")
                .email("user@simbirsoft.com")
                .password("qwerty123")
                .role("USER")
                .build();
        accountList.add(accountDto);

        teacherService.saveAllAccounts(accountList);
    }

}

