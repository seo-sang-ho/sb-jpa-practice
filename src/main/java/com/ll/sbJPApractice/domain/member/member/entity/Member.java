package com.ll.sbJPApractice.domain.member.member.entity;

import com.ll.sbJPApractice.global.jpa.baseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Entity
@SuperBuilder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Getter
@Setter
@ToString(callSuper = true)
public class Member extends baseEntity {
    private String username;
    private String password;
}
