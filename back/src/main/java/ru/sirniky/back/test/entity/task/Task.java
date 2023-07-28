package ru.sirniky.back.test.entity.task;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import ru.sirniky.back.test.entity.test.Test;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Builder
public class Task {
    @Id
    private Long id;
    private String question;
    private String answer;
    @ManyToMany
    private List<Test> tests;

}
