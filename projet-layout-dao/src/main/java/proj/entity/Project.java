package proj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@ToString(of = {"projectId","startDate","endDate"})
@Table(name = "PROJECT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project implements Serializable {

    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private Set<Assignment> assignments;

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

    }


