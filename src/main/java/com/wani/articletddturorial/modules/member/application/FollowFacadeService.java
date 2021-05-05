package com.wani.articletddturorial.modules.member.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FollowFacadeService {

    private final FollowManager followManager;

    public FollowFacadeService(FollowManager followManager) {
        this.followManager = followManager;
    }
}
