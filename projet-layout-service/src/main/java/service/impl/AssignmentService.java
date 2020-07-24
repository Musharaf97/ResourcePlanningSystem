package service.impl;


import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Component;
import proj.entity.Assignment;
import proj.entity.Project;
import proj.entity.QAssignment;
import proj.repo.AssignmentRepo;
import service.model.AssignResourceDto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;


@Component
public class AssignmentService {

    public AssignmentService(AssignmentRepo assignmentRepo) {

        this.assignmentRepo = assignmentRepo;
    }

    private final AssignmentRepo assignmentRepo;

    public Assignment assignResource(AssignResourceDto request) {
        // Validate Data
        // TODO validation api
        // Validate Business
        // 1) does user exist

        // 2) does mainTechnologyId exist
//        BooleanExpression doesMainTechnologyExist = QMainTechnology.mainTechnology.mainTechnologyId.eq(request.getMainTechnologyId());
        BooleanExpression doesMainTechnologyExist = QAssignment.assignment.mainTechnology.mainTechnologyId.eq(request.getMainTechnologyId());

        // 3) does project exist
        BooleanExpression doesProjectExist = QAssignment.assignment.project.projectId.eq(request.getProjectId());
        // 4) is resource over allocated
        BooleanExpression hasVisa = QAssignment.assignment.resource.visa.eq(request.getVisa());
        BooleanExpression isInRange = QAssignment.assignment.endDate.lt(request.getStartDate())
                .and(QAssignment.assignment.startDate.gt(request.getEndDate()))
                .not();

        BooleanExpression where = hasVisa.and(isInRange).and(doesMainTechnologyExist).and(doesProjectExist);

        List<Assignment> existingAssignment = (List<Assignment>) assignmentRepo.findAll(where);

        // TODO for each day add and check the allocation
        long days = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
        LongStream.range(0, days).forEach(day -> {
            LocalDate dateToCheck = request.getStartDate().plusDays(days);
            //TODO get matching from existing, add allocations and throw if > 1
            Double totalAllotment = existingAssignment.stream().map(Assignment::getAllotment).reduce(0.0, Double::sum);
            if (totalAllotment >= 1) {
                throw new IllegalStateException("Resource is over-allocated!");
            }
        });
        Assignment assignment = new Assignment();
        return assignmentRepo.save(assignment);
    }

    //find all assignments
    public List<Assignment> findAll() {
        return assignmentRepo.findAll();
    }


    public Optional<List<Assignment>> findAssignmentByProjectId(long projectId) {
        return assignmentRepo.findByProject_ProjectId(projectId);
    }

    public Optional<List<Assignment>> findAssignmentByResourceId(long resourceId) {
        return assignmentRepo.findByResource_ResourceId(resourceId);
    }

}




