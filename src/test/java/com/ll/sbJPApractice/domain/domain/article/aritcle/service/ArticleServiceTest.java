package com.ll.sbJPApractice.domain.domain.article.aritcle.service;

import com.ll.sbJPApractice.domain.article.article.entitry.Article;
import com.ll.sbJPApractice.domain.article.article.service.ArticleService;
import com.ll.sbJPApractice.global.rsData.RsData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    @DisplayName("글쓰기")
    void t1(){
        RsData<Article> writeRs = articleService.write("제목1", "내용1");
        Article article = writeRs.getData();
        assertThat(article.getId()).isGreaterThan(0L);
    }
}
