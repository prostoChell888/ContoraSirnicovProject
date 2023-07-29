package ru.sirniky.back.util.password;

import lombok.RequiredArgsConstructor;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordGeneratorImpl implements PasswordGenerator {

    private final RandomStringGenerator passwordGenerator;
    private final Environment environment;

    @Override
    public String generate() {
        return passwordGenerator.generate(environment.getProperty("password.length", Integer.class));
    }
}
