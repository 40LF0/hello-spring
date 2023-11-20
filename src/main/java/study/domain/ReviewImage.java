package study.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
public class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ReviewImageId;
    private String imageUrl;
    private LocalDate createdAt;
    private LocalDate updateAt;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

}
