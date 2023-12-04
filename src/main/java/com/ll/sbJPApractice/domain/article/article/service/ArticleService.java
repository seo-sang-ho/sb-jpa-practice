package com.ll.sbJPApractice.domain.article.article.service;

import com.ll.sbJPApractice.domain.article.article.entity.Article;
import com.ll.sbJPApractice.domain.article.article.repository.ArticleRepository;
import com.ll.sbJPApractice.domain.article.articleComment.entity.ArticleComment;
import com.ll.sbJPApractice.domain.member.member.entity.Member;
import com.ll.sbJPApractice.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public RsData<Article> write(long authorId, String title, String body) {
        Article article = Article.builder()
                .author(Member.builder().id(authorId).build())
                .modifyDate(LocalDateTime.now())
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return RsData.of("200","%s번 게시물이 작성되었습니다.".formatted(article.getId()),article);
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    @Transactional
    public void modify(Article article, String title, String body) {
        article.setTitle(title);
        article.setBody(body);
    }

    @Transactional
    public void modifyComment(ArticleComment comment, String body) {
        comment.setBody(body);
    }
}