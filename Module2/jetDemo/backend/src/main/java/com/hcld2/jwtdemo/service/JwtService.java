package com.hcld2.jwtdemo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;


import java.util.Date;

public class JwtService {
    private final Algorithm algorithm;
    private final JWTVerifier verifier;
    private final long expireMs;

    public JwtService(@Value("${app.jwt.secret}") String secret, @Value("${app.jwt.expiration-ms}") long expirationMs) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.verifier = com.auth0.jwt.JWT.require(algorithm).build();
        this.expireMs = expirationMs;
    }
    public String generateToken(String username) {
        Date now = new Date();
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(now)
                .withExpiresAt(new Date(now.getTime() + expireMs))
                .sign(algorithm);
    }

    public String validateTokenAndRetrieveSubject(String token) {
        try {
            return verifier.verify(token).getSubject();
        } catch (Exception e){
            return null;
        }
    }

    public String verifyAndGetUsername(String substring) {
        return validateTokenAndRetrieveSubject(substring);
    }
}
