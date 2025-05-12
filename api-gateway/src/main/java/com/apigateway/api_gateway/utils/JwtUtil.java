package main.java.com.apigateway.api_gateway.utils;

@Component
public class JwtUtil {

    @Value("${demo.jwt.secret}")
    private String secret;

    public Claims extractAllClaims(String token) throws Exception {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}