package com.yernar.car.database.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class AuthenticationService {
    static final long EXPIRATIONTIME = 864_000_00; // 1 day in milliseconds
    static final String SIGNINGKEY = "SecretKey743qhriuewioyd8w495d0jq98w4u9uq9du98e4urt98uhvaohodsrscojzdjdsae4sadijoi4udaseuads84dasocj48cu30adsu085u3";
    static final String PREFIX = "Bearer";

    // Add token to Authorization header
    static public void addToken(HttpServletResponse res, String username) {
        String JwtToken = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()
                        + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
                .compact();
        res.addHeader("Authorization", PREFIX + " " + JwtToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    // Get token from Authorization header
    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SIGNINGKEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null)
                return new UsernamePasswordAuthenticationToken(user, null,
                        emptyList());
        }
        return null;
    }
}
