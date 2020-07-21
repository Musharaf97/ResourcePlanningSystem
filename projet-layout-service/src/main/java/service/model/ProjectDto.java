package service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ProjectDto {

    Long projectId;
    String status;
    String title;
    String BL;

    LocalDate startDate;
    LocalDate endDate;

    BigDecimal winChance;

}
