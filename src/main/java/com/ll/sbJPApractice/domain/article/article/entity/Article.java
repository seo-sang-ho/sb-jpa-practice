package com.ll.sbJPApractice.domain.article.article.entity;

import com.ll.sbJPApractice.domain.article.articleComment.entity.ArticleComment;
import com.ll.sbJPApractice.domain.article.articleTag.entity.ArticleTag;
import com.ll.sbJPApractice.domain.member.member.entity.Member;
import com.ll.sbJPApractice.global.jpa.baseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@SuperBuilder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Getter
@Setter
@ToString(callSuper = true)
public class Article extends baseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;
    private String title;
    private String body;
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ArticleComment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ArticleTag> tags = new ArrayList<>();

    public void addComment(Member commentAuthor, String commentBody) {
        ArticleComment comment = ArticleComment.builder()
                .article(this)
                .author(commentAuthor)
                .body(commentBody)
                .build();

        comments.add(comment);
    }

    public void removeComment(ArticleComment comment) {
        comments.remove(comment);
    }

    public void addTag(String tagContent) {
        ArticleTag tag = ArticleTag.builder()
                .article(this)
                .content(tagContent)
                .build();

        tags.add(tag);
    }

    public void addTag(String... tagContents) {
        for(String tagContent : tagContents){
            addTag(tagContent);
        }
    }
}
