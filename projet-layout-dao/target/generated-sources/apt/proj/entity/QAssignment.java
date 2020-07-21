package proj.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAssignment is a Querydsl query type for Assignment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAssignment extends EntityPathBase<Assignment> {

    private static final long serialVersionUID = -1492162169L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAssignment assignment = new QAssignment("assignment");

    public final NumberPath<Double> allotment = createNumber("allotment", Double.class);

    public final NumberPath<Long> assignmentId = createNumber("assignmentId", Long.class);

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final StringPath main_role = createString("main_role");

    public final QMainTechnology mainTechnologies;

    public final QProject project;

    public final QResource resource;

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public QAssignment(String variable) {
        this(Assignment.class, forVariable(variable), INITS);
    }

    public QAssignment(Path<? extends Assignment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAssignment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAssignment(PathMetadata metadata, PathInits inits) {
        this(Assignment.class, metadata, inits);
    }

    public QAssignment(Class<? extends Assignment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mainTechnologies = inits.isInitialized("mainTechnologies") ? new QMainTechnology(forProperty("mainTechnologies")) : null;
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project")) : null;
        this.resource = inits.isInitialized("resource") ? new QResource(forProperty("resource")) : null;
    }

}

