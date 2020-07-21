package service.impl;

import antlr.collections.impl.IntRange;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Component;
import proj.entity.Assignment;
import proj.entity.QAssignment;
import proj.repo.AssignmentRepo;
import service.model.AssignResourceDto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.LongStream;


@Component
public class AssignmentService {

    private final AssignmentRepo assignmentRepo;

    public AssignmentService(AssignmentRepo assignmentRepo) {
        this.assignmentRepo = assignmentRepo;
    }

    public Assignment assignResource(AssignResourceDto request) {
        // Validate Data
        // TODO validation api
        // Validate Business
        // 1) does user exist
        // 2) does mainTechnologyId exist
        // 3) does project exist
        // 4) is resource over allocated
        BooleanExpression hasVisa  = QAssignment.assignment.resource.visa.eq(request.getVisa());
        BooleanExpression isInRange =  QAssignment.assignment.endDate.lt(request.getStartDate())
                .and(QAssignment.assignment.startDate.gt(request.getEndDate()))
                .not();

        BooleanExpression where = hasVisa.and(isInRange);
        Iterable<Assignment> existing = assignmentRepo.findAll(where);
        // TODO for each day add and check the allocation
        long days = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate());
        LongStream.range(0, days).forEach(day ->{
            LocalDate dateToCheck = request.getStartDate().plusDays(days);
            //TODO get matching from existing, add allocations and throw if > 1
        });

        Assignment assignment = Assignment.builder()
                .build();

        return assignmentRepo.save(assignment);
    }

    public Assignment save(Assignment assignment) {
        return assignmentRepo.save(assignment);
    }

    public List<Assignment> findAll() {
        return assignmentRepo.findAll();
    }

}
