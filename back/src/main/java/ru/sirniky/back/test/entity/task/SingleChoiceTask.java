package ru.sirniky.back.test.entity.task;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SingleChoiceTask extends Task {
    @Id
    private Long id;
    private String options;

    public boolean checkAnswer(Object answer) {
        return false;
    }
}

