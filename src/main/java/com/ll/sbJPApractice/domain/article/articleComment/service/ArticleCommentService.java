package com.ll.sbJPApractice.domain.article.articleComment.service;

import com.ll.sbJPApractice.domain.article.article.entity.Article;
import com.ll.sbJPApractice.domain.article.articleComment.entity.ArticleComment;
import com.ll.sbJPApractice.domain.article.articleComment.repository.ArticleCommentRepository;
import com.ll.sbJPApractice.domain.member.member.entity.Member;
import com.ll.sbJPApractice.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {
    private final ArticleCommentRepository articleCommentRepository;

    public RsData<ArticleComment> write(Member author, Article article, String body) {
        ArticleComment articleComment = ArticleComment.builder()
                .article(article)
                .author(author)
                .body(body)
                .build();

        articleCommentRepository.save(articleComment);

        return RsData.of("200","%d번 댓글이 작성되었습니닫.".formatted(articleComment.getId()),articleComment);
    }

    public Optional<ArticleComment> findLastest() {
        return articleCommentRepository.findFirstByOrderByIdDesc();
    }

    @Transactional
    public void modify(ArticleComment comment, String body) {
        comment.setBody(body);
    }

    public Optional<ArticleComment> findFirstByArticleIdOrderByDesc(long id) {
        return articleCommentRepository.findFirstByArticleIdOrderByIdDesc(id);
    }

    public void delete(ArticleComment comment) {
        articleCommentRepository.delete(comment);
    }
}
