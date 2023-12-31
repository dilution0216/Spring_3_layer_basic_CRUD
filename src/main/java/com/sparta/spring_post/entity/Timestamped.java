package com.sparta.spring_post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {
    @CreatedDate
    @Column(updatable = false) // 처음만 생성되고 업데이트를 false로 막음
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt; // 작성시간

    @LastModifiedDate //조회한 Entity객체의 값을 변경할 때마다 변경된 시간이 자동으로 저장
    @Column
    @Temporal(TemporalType.TIMESTAMP) //날짜 데이터를 매핑할 때 사용하는 어노테이션
    private LocalDateTime modifiedAt; //수정시간

}