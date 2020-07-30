package proj.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;



@ToString(of = {"assignmentId"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ASSIGNMENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Assignment implements Serializable {

    @Id
    @Column(name = "ASSIGNMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assignmentId;

    @Column(name = "MAIN_ROLE")
    private String mainRole;

    @Column(name = "ALLOTMENT")
    private Double allotment;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "resourceId", nullable = false)
    private Resource resource;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "projectId", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mainTechnologyId", nullable = false)
    private MainTechnology mainTechnology;

}
