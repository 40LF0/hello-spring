package study.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
public class MemberPrefer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionId;
    private LocalDate createdAt;
    private LocalDate updateAt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "terms_id")
    private Terms terms;

}
