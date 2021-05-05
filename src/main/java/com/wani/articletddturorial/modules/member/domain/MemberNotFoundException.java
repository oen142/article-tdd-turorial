package com.wani.articletddturorial.modules.member.domain;

import com.wani.articletddturorial.modules.common.exception.SystemException;

public class MemberNotFoundException extends SystemException {

    public MemberNotFoundException() {
        super("member not found");
    }
}
