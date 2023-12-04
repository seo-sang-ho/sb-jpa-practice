package com.ll.sbJPApractice.domain.article.articleTag.entity;

import com.ll.sbJPApractice.domain.article.article.entity.Article;
import com.ll.sbJPApractice.global.jpa.baseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Entity
@SuperBuilder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Getter
@Setter
@ToString(callSuper = true)
public class ArticleTag extends baseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;
    private String content;
}
