package com.ll.sbJPApractice.domain.member.member.service;

import com.ll.sbJPApractice.domain.member.member.entity.Member;
import com.ll.sbJPApractice.domain.member.member.repository.MemberRepository;
import com.ll.sbJPApractice.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public RsData<Member> join(String username, String password) {
        Member member = Member.builder()
                .username(username)
                .password(password)
                .build();

        memberRepository.save(member);

        return RsData.of("200","%s님 가입을 환영합니다.".formatted(username),member);
    }
}
