package proj.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@ToString(of = {"assignmentId"})
@Entity
@Table(name = "ASSIGNMENT")
public class Assignment implements Serializable {

    @Id
    @Column(name = "ASSIGNMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assignmentId;

    @Column(name = "MAIN_ROLE")
    private String main_role;

    @Column(name = "ALLOTMENT")
    private Double allotment;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RESOURCE_ID", nullable = false)
    private Resource resource;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mainTechnology_id")
    private MainTechnology mainTechnologies;

}
