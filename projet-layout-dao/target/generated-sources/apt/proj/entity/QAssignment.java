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

    public final StringPath endDate = createString("endDate");

    public final StringPath mainRole = createString("mainRole");

    public final QMainTechnology mainTechnology;

    public final QProject project;

    public final QResource resource;

    public final StringPath startDate = createString("startDate");

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
        this.mainTechnology = inits.isInitialized("mainTechnology") ? new QMainTechnology(forProperty("mainTechnology")) : null;
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project")) : null;
        this.resource = inits.isInitialized("resource") ? new QResource(forProperty("resource")) : null;
    }

}

