package study.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionId;
    private Long reward;
    private LocalDate deadline;
    private String mission_spec;
    private LocalDate createdAt;
    private LocalDate updateAt;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;


    //@Column(name = "username")
    private String name;
}
