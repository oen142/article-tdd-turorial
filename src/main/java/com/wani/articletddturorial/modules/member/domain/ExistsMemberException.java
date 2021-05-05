package com.wani.articletddturorial.modules.member.domain;

import com.wani.articletddturorial.modules.common.exception.SystemException;

public class ExistsMemberException extends SystemException {

    public ExistsMemberException() {
        super("exists follow member");
    }
}
