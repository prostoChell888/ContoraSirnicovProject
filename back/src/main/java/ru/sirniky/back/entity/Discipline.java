package ru.sirniky.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import ru.sirniky.back.entity.task.Task;
import ru.sirniky.back.entity.test.Test;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "indicator_code")
    private String indicatorCode;

    @ManyToMany()
    @JoinTable(
            name = "discipline_competencies_map",
            joinColumns = @JoinColumn(
                    name = "discipline_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "competencies_id",
                    referencedColumnName = "id"
            )
    )
    private List<Competencies> competencies;

    @OneToMany(mappedBy = "discipline")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Test> tests;

    @OneToMany(mappedBy = "discipline")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Task> tasks;
}
