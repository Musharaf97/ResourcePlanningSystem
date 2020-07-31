package proj.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"projectId"})
@Table(name = "PROJECT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project implements Serializable {

    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BL")
    private String BL;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

    @Column(name = "WIN_CHANCE")
    private Double winChance;

    @Column(name = "No_Of_Resources")
    private Integer noOfResources;

    }


