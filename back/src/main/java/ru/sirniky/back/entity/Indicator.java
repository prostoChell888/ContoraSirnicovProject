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
@Table(name = "indicator")
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "indicator_code")
    private String indicatorCode;

    @Column(name = "name_of_indicator")
    private String nameOfIndicator;

    @ManyToOne
    @JoinColumn(name = "competencies_id",
            referencedColumnName = "id")
    private Competencies competenciesId;
}
