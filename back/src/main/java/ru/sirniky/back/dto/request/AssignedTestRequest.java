package ru.sirniky.back.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import ru.sirniky.back.entity.Student;
import ru.sirniky.back.entity.test.Test;

import java.sql.Timestamp;
import java.util.List;


@Data
public class AssignedTestRequest {

    @NotNull @Min(1)
    private Long id;
    @NotNull @Min(1)
    private Integer testId;
    @NotNull @Min(1)
    private Integer teacherId;
    @NotNull @Min(1)
    List<Integer> teachersIds;
    @NotNull
    List<@Min(1) Long> testResultsIds;

    Timestamp endOfTestTime;
}
