package proj.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProject is a Querydsl query type for Project
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProject extends EntityPathBase<Project> {

    private static final long serialVersionUID = -252448097L;

    public static final QProject project = new QProject("project");

    public final StringPath BL = createString("BL");

    public final StringPath endDate = createString("endDate");

    public final NumberPath<Long> projectId = createNumber("projectId", Long.class);

    public final StringPath startDate = createString("startDate");

    public final StringPath status = createString("status");

    public final StringPath title = createString("title");

    public final NumberPath<Double> winChance = createNumber("winChance", Double.class);

    public QProject(String variable) {
        super(Project.class, forVariable(variable));
    }

    public QProject(Path<? extends Project> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProject(PathMetadata metadata) {
        super(Project.class, metadata);
    }

}

