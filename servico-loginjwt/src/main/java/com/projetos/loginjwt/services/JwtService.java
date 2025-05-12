package com.projetos.loginjwt.service;

@Service
public class JwtService {
    @Value("${demo.jwt.secret}")
    private String secret;

    @Value("${demo.jwt.expiration}")
    private long expiration;

    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims parseToken(String token) throws Exception {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}