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
@Table(name = "competencies")
public class Competencies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "competence_code")
    private String competenceCode;

    @Column(name = "name_of_universal_competence")
    private String nameOfUniversalCompetence;

    @ManyToMany()
    @JoinTable(
            name = "competencies_educational_program_map",
            joinColumns = @JoinColumn(
                    name = "educational_program_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "competencies_id",
                    referencedColumnName = "id"
            )
    )
    private List<EducationalProgram> educationalPrograms;
}
