package ru.sirniky.back.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "education_level")
public class EducationLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "ugsn_code")
    private String ugsnCode;

    @Column(name = "ugsn_label")
    private String ugsnLabel;

}
