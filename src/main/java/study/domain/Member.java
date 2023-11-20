package study.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String name;
    private String gender;
    private Long age;
    private String address;
    private String spec_address;
    private String status;
    private LocalDate inactiveDate;
    private String socialType;
    private LocalDate createAt;
    private LocalDate updateAt;
    private String email;
    private Long point;
}
