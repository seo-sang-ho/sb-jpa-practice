package com.ll.sbJPApractice.domain.article.article.service;

import com.ll.sbJPApractice.domain.article.article.entitry.Article;
import com.ll.sbJPApractice.domain.article.article.repository.ArticleRepository;
import com.ll.sbJPApractice.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public RsData<Article> write(String title, String body) {
        Article article = Article.builder()
                .title(title)
                .body(body)
                .build();

        articleRepository.save(article);

        return RsData.of("200","%s번 게시물이 작성되었습니다.".formatted(article.getId()),article);
    }
}