package service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class AssignResourceDto {

    String visa;
    Long projectId;
    Long mainTechnologyId;
    String mainRole;

    BigDecimal allotment;

    LocalDate startDate;
    LocalDate endDate;

}
