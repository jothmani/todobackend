package com.jothmart.todobackend.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    // private String secretKey = "cF7812hfdG9kb2JhY2tlbmQgc2VjcmV0IGtleSBmb3IganV3dCBnZW5lcmF0aW9u"; // Example secret key

        private String secretKey = "";

        public JWTService() {
            try {
                KeyGenerator keyGen = KeyGenerator.getInstance("HmacSha256");
                // javax.crypto.SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
                keyGen.init(256);
                Key key = keyGen.generateKey();
                secretKey = java.util.Base64.getEncoder().encodeToString(key.getEncoded());
            } catch (Exception e) {
                throw new RuntimeException("Error generating secret key for JWT", e);
            }
        }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(getKey())
                .compact();
    }

    private Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }

}
