package com.fatec.grupo3.utils;

import javax.servlet.http.HttpServletRequest;

public class TokenUtils {

    public static String wrapperToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if (header == null || header.isEmpty() || !header.startsWith("Bearer ")) {
            return null;
        }
        String token = header.substring(7, header.length());

        return token;
    }
}
