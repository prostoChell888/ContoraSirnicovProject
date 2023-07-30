package ru.sirniky.back.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssignedTestResponse {
    private Long id;
    private Long testId;
    private Long teacherId;
    private List<Integer> studentIda;
    private Timestamp endOfTestTime;
}
