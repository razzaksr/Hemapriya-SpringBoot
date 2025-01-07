package microservice.four.api_gateway;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtility {
    public static String secret="2pQrcPHTt+ItCBZi9I/VxHzuAUZK9bCltDIWPakqL6Y=";
    // public static String secret="hemapriyaprojectkey";

    // public String generateToken(String username){
    //     return Jwts.builder()
    //     .claims()
    //     .add(new HashMap<String,Object>())
    //     .subject(username)
    //     .issuedAt(new Date(System.currentTimeMillis()))
    //     .expiration(new Date(System.currentTimeMillis()+60*60*30))
    //     .and().signWith(getSignInKey())
    //     .compact();
    // }

    public String extractUsername(String token) { 
        return Jwts.parser().setSigningKey(getSignInKey())
        .build().parseClaimsJws(token)
        .getBody().getSubject();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(getSignInKey()).build().parseClaimsJws(token);
            return true;
        }
        catch (JwtException | IllegalArgumentException e) { 
            return false;
        }
    }
    
    public Key getSignInKey(){
        byte[] arr = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(arr);
    }
}
