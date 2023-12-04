package com.ll.sbJPApractice.domain.article.articleComment.repository;

import com.ll.sbJPApractice.domain.article.articleComment.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleCommentRepository extends JpaRepository<ArticleComment,Long> {
    Optional<ArticleComment> findFirstByOrderByIdDesc();

    Optional<ArticleComment> findFirstByArticleIdOrderByIdDesc(long id);
}
