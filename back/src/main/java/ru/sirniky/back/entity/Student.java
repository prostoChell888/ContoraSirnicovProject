package ru.sirniky.back.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Student extends PersonInfo {

    @Column(name = "record_book", unique = true)
    private String recordBook;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
