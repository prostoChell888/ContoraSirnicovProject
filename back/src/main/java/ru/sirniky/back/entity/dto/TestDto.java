package ru.sirniky.back.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestDto {

    private String name;
    private List<Long> taskIds;
}
