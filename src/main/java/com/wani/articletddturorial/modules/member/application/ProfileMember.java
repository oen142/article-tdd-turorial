package com.wani.articletddturorial.modules.member.application;

import com.wani.articletddturorial.modules.member.domain.Member;
import lombok.Getter;

@Getter
public class ProfileMember {

    private final Member member;
    private final boolean following;

    public ProfileMember(Member member, boolean following) {
        this.member = member;
        this.following = following;
    }

    public ProfileMember(Member member) {
        this(member, false);
    }
}
