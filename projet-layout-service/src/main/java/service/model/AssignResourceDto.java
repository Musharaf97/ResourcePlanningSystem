package service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

//    String visa;
    Long resourceId;
    Long projectId;
    Long mainTechnologyId;
    String mainRole;
    Double allotment;
    String startDate;
    String endDate;

//    @JsonFormat(pattern = "dd-MM-yyyy")
//    LocalDate startDate;
//
//    @JsonFormat(pattern = "dd-MM-yyyy")
//    LocalDate endDate;

}
