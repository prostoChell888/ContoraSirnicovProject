package ru.sirniky.back.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestDto {

    private String name;
    private List<Long> taskIds;
}
