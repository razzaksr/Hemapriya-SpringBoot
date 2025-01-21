package microservice.four.api_gateway;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
    private final String secret = "2pQrcPHTt+ItCBZi9I/VxHzuAUZK9bCltDIWPakqL6Y=";
    private Key getKey(){
        byte[] arr = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(arr);
    }
    public Jws<Claims> validateToken(String token){
        return Jwts.parser().setSigningKey(getKey()).build().parseClaimsJws(token);
    }
}
