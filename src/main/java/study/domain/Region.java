package study.domain;

import lombok.*;
import study.domain.baseEntity.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;
    @Column(nullable = false,length = 20)
    private String name;

}
