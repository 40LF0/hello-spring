package study.domain;

import lombok.*;
import study.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false,length = 10)
    private String gender;
    private Long age;
    @Column(nullable = false,length = 40)
    private String address;
    @Column(length = 40)
    private String spec_address;
    @Column(nullable = false,length = 15)
    private String status;
    private LocalDate inactiveDate;
    @Column(length = 10)
    private String socialType;
    @Column(nullable = false,length = 50)
    private String email;
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
