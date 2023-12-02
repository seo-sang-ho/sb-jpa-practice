package com.ll.sbJPApractice.domain.member.member.service;

import com.ll.sbJPApractice.domain.member.member.entity.Member;
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
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("회원가입")
    void t1(){
        RsData<Member> user = memberService.join("userNew", "1234");
        Member member = user.getData();
        assertThat(member.getId()).isGreaterThan(0L);
    }
}
