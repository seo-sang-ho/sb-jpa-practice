package com.ll.sbJPApractice.domain.domain.article.aritcle.service;

import com.ll.sbJPApractice.domain.article.article.entity.Article;
import com.ll.sbJPApractice.domain.article.article.service.ArticleService;
import com.ll.sbJPApractice.domain.member.member.entity.Member;
import com.ll.sbJPApractice.domain.member.member.service.MemberService;
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
    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("글쓰기")
    void t1(){
        RsData<Article> writeRs = articleService.write(1,"제목1", "내용1");
        Article article = writeRs.getData();
        assertThat(article.getId()).isGreaterThan(0L);
    }

    @Test
    @DisplayName("1번글의 작성자의 username을 가져온다.")
    void t2(){
        Article article = articleService.findById(1L).get();
        long authorId = article.getAuthorId();

        Member member = memberService.findById(authorId).get();

        assertThat(member.getUsername()).isEqualTo("user1");
    }
}
