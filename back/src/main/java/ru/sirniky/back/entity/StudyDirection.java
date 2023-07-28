package ru.sirniky.back.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "study_direction")
public class StudyDirection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "direction_code")
    private String directionCode;

    @Column(name = "name_of_direction")
    private String nameOfDirection;

    @Column(name = "educational_program")
    private String educationalProgram;

    @ManyToOne
    @JoinColumn(name = "educational_level_id",
            referencedColumnName = "id")
    private EducationLevel educationLevel;
}
