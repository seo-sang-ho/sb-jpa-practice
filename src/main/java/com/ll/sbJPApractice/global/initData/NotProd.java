package com.ll.sbJPApractice.global.initData;

import com.ll.sbJPApractice.domain.member.member.entity.Member;
import com.ll.sbJPApractice.domain.member.member.service.MemberService;
import com.ll.sbJPApractice.global.rsData.RsData;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!prod")
@Configuration
public class NotProd {
    @Bean
    public ApplicationRunner initNotProdData(
            MemberService memberService
    ){
        return args -> {
            RsData<Member> joinRs = memberService.join("user1", "1234");

            System.out.println(joinRs.getMsg());
        };
    }
}
