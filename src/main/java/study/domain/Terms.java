package study.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Entity
public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termsId;
    private String title;
    private String body;
    private Boolean optional;
    private LocalDate createdAt;
    private LocalDate updateAt;

}
