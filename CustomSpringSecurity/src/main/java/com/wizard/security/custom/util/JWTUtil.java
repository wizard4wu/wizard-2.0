package com.wizard.security.custom.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wizard.security.custom.domain.LoginUser;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Optional;


public class JWTUtil {

    private static final String salt = "jwt.io";



    public static String createTokenByUser(LoginUser loginUser){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 300);

        String token = JWT.create()
                .withClaim("aud", "localhost") //发送方
                .withClaim("iss", "wizard") //接收方
                .withClaim("userName", loginUser.getUsername())
                .withClaim("email", loginUser.getEmail())
                .withClaim("id", loginUser.getId())
                .withClaim("age", loginUser.getAge())
                .withClaim("phoneNum", loginUser.getPhoneNum())
                .withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(salt.getBytes(StandardCharsets.UTF_8)));
        return token;
    }

    public static JWTVerifier createVerifierObject() {
        return JWT.require(Algorithm.HMAC256(salt.getBytes(StandardCharsets.UTF_8))).build();
    }

    public static DecodedJWT verifyToken(String token){
       return createVerifierObject().verify(token);
    }

    public static LoginUser parseToken(String token){
        DecodedJWT decodedJWT = verifyToken(token);
        LoginUser loginUser = new LoginUser();
        Optional.ofNullable(decodedJWT.getClaim("userName").asString()).ifPresent( value -> loginUser.setName(value));
        Optional.ofNullable(decodedJWT.getClaim("email").asString()).ifPresent( value -> loginUser.setEmail(value));
        Optional.ofNullable(decodedJWT.getClaim("id").asString()).ifPresent( value -> loginUser.setId(value));
        Optional.ofNullable(decodedJWT.getClaim("age").asInt()).ifPresent( value -> loginUser.setAge(value));
        Optional.ofNullable(decodedJWT.getClaim("phoneNum").asString()).ifPresent( value -> loginUser.setPhoneNum(value));
        return loginUser;
    }

    public static void main(String[] args) {

        LoginUser loginUser = new LoginUser();
        loginUser.setName("wizard");
        loginUser.setEmail("111@baidu.com");
        String token = createTokenByUser(loginUser);
        System.out.println(token);
    }
}
