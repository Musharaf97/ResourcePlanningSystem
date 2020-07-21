package proj.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMainTechnology is a Querydsl query type for MainTechnology
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMainTechnology extends EntityPathBase<MainTechnology> {

    private static final long serialVersionUID = -78689953L;

    public static final QMainTechnology mainTechnology = new QMainTechnology("mainTechnology");

    public final NumberPath<Long> mainTechnologyId = createNumber("mainTechnologyId", Long.class);

    public final StringPath mainTechnologyName = createString("mainTechnologyName");

    public QMainTechnology(String variable) {
        super(MainTechnology.class, forVariable(variable));
    }

    public QMainTechnology(Path<? extends MainTechnology> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMainTechnology(PathMetadata metadata) {
        super(MainTechnology.class, metadata);
    }

}

