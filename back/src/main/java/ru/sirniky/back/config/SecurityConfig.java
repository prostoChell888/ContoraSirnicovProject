package ru.sirniky.back.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.sirniky.back.service.impl.UserDetailsServiceImpl;
import ru.sirniky.back.util.RoleEnum;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);

        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf()
                .disable()
                .cors()
                .and().authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin/**")
                            .hasRole(RoleEnum.ADMIN.name())
                        .requestMatchers("/teacher/**")
                            .hasRole(RoleEnum.TEACHER.name())
                        .anyRequest()
                            .permitAll()
                )
                .httpBasic(Customizer.withDefaults());

        httpSecurity.authenticationProvider(authenticationProvider());

        return httpSecurity.build();
    }
}
