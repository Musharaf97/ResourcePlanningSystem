package proj.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@ToString(of = {"mainTechnologyId"})
@Entity
@Table(name = "MAIN_TECHNOLOGY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MainTechnology implements Serializable {

    @Id
    @Column(name = "MAIN_TECHNOLOGY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mainTechnologyId;

    @Column(name = "MAIN_TECHNOLOGY_NAME")
    private String mainTechnologyName;

}
