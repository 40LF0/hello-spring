package study.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String name;
    private String address;
    private Double score;
    private LocalDate createdAt;
    private LocalDate updateAt;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
