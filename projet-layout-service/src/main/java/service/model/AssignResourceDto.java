package service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.ap.internal.model.common.Assignment;
import proj.entity.MainTechnology;
import proj.entity.Project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignResourceDto  {

    String visa;
    Long projectId;
    Long mainTechnologyId;
    String mainRole;

    Double allotment;

    LocalDate startDate;
    LocalDate endDate;

}
