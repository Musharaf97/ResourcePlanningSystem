package proj.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"resourceId"})
@Entity
@Table(name = "RESOURCE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resource implements Serializable {

    @Id
    @Column(name = "RESOURCE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resourceId;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "VISA", unique = true)
    private String visa;

    @Column(name = "LEVEL")
    private Double level;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PROFILE")
    private String profile;

    @Column(name = "FACTORY")
    private String factory;

}
