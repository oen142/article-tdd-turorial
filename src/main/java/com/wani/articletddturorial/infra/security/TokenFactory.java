package com.wani.articletddturorial.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenFactory {

    @Value("")
    private Integer expirationTime;

    @Value("")
    private String signKey;

    @Value("")
    private String issuer;

    public String create(String email) {
        LocalDateTime currentTime = LocalDateTime.now();
        return JWT.create()
            .withSubject(email)
            .sign(Algorithm.ECDSA256(signKey));
    }
}
