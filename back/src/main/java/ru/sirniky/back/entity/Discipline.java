package ru.sirniky.back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
            name = "competencies_educational_program_map",
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
}
