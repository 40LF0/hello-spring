package study.domain;

import lombok.Getter;
import study.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
public class ReviewImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ReviewImageId;
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

}
