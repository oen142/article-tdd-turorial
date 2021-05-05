package com.wani.articletddturorial.modules.member.domain;

import com.wani.articletddturorial.modules.member.application.ProfileMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FollowManager {

    private final MemberRepository memberRepository;

    public ProfileMember follow(Member member, String username) {
        Member target = memberRepository.findByUsername(username)
            .orElseThrow(MemberNotFoundException::new);
        member.follow(target);

        return new ProfileMember(target, member.follow(target));
    }
}
