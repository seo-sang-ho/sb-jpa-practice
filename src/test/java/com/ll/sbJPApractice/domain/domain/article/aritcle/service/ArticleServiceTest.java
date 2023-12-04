package com.ll.sbJPApractice.domain.domain.article.aritcle.service;

import com.ll.sbJPApractice.domain.article.article.entity.Article;
import com.ll.sbJPApractice.domain.article.article.service.ArticleService;
import com.ll.sbJPApractice.domain.article.articleComment.entity.ArticleComment;
import com.ll.sbJPApractice.domain.article.articleComment.service.ArticleCommentService;
import com.ll.sbJPApractice.domain.member.member.entity.Member;
import com.ll.sbJPApractice.domain.member.member.service.MemberService;
import com.ll.sbJPApractice.global.rsData.RsData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
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
    @Autowired
    private ArticleCommentService articleCommentService;

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
        Member author = article.getAuthor();


        assertThat(author.getUsername()).isEqualTo("user1");
    }

    @Test
    @DisplayName("1번글 확인")
    void t3(){
        Article article = articleService.findById(1L).get();

        assertThat(article.getTitle()).isEqualTo("제목1");
    }

    @Test
    @DisplayName("1번글 제목을 수정")
    void t4(){
        Article article = articleService.findById(1L).get();

        articleService.modify(article,"수정된 제목","수정된 내용");

        Article article1 = articleService.findById(1L).get();
        Assertions.assertThat(article1.getTitle()).isEqualTo("수정된 제목");
    }

    @Test
    @DisplayName("1번글의 댓글들을 수정한다.")
    @Rollback(value = false)
    void t5() {
        ArticleComment comment = articleCommentService.findLastest().get();

        articleCommentService.modify(comment,"new body");

    }

    @Test
    @DisplayName("1번글의 댓글을 삭제한다.")
    @Rollback(value = false)
    void t6() {
        ArticleComment comment = articleCommentService.findFirstByArticleIdOrderByDesc(1L).get();

        articleCommentService.delete(comment);
    }

    @Test
    @DisplayName("2번글에 댓글 추가한다.")
    @Rollback(value = false)
    void t7() {
        Member member1 = memberService.findById(1L).get();
        Article article = articleService.findById(2L).get();

        articleCommentService.write(member1,article,"댓글1");
    }
}
