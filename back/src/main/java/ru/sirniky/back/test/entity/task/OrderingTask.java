package ru.sirniky.back.test.entity.task;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderingTask extends Task {
    @Id
    private Long id;
    private String options;

    public boolean checkAnswer(String answer) {
       return false;
    }
}

