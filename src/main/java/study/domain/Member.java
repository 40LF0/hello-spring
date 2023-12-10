package study.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import study.domain.baseEntity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(nullable = false,length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 10)
    private Gender gender;
    private Long birthYear;
    private Long birthMonth;
    private Long birthDay;
    @Column(nullable = false,length = 40)
    private String address;
    @Column(length = 40)
    private String specAddress;

    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private String status;
    private LocalDate inactiveDate;
    @Column(length = 10)
    private String socialType;
    @Column(length = 50)
    private String email;
    @ColumnDefault("0")
    private Long point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
