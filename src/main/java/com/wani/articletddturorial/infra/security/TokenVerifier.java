package com.wani.articletddturorial.infra.security;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenVerifier {

    private final String signKey;
    private final String token;

    public TokenVerifier(String signKey, String token) {
        this.signKey = signKey;
        this.token = token;
    }

    /*public Optional<String> parseClaims(){
        try{
            Jwt<Claims> claims =
        }
    }*/
}
