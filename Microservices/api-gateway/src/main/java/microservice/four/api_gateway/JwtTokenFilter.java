package microservice.four.api_gateway;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

@Component
public class JwtTokenFilter extends AbstractGatewayFilterFactory<JwtTokenFilter.Config>{
    public static class Config {}

    public JwtTokenFilter(){super(Config.class);}

    @Autowired
    JwtUtility jwtUtil;

    @Override
    public GatewayFilter apply(Config config) {
        // TODO Auto-generated method stub
        return (exchange, chain) -> {
            String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return Mono.error(new RuntimeException("Missing or invalid Authorization header"));
            }

            String token = authHeader.substring(7);
            try {
                // logger.info("Token about to extract");
                // Claims claims = jwtUtil.validateToken(token).getBody();
                // logger.info("token claims");
                // logger.info(claims.toString());
                if(jwtUtil.validateToken(token)){

                }
                else{
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
                exchange.getRequest().mutate().header("username", jwtUtil.extractUsername(token));
            } catch (Exception e) {
                return Mono.error(new RuntimeException("Invalid JWT token"));
            }
            return chain.filter(exchange);
        };
    }
}
//extends OncePerRequestFilter {
//     private final JwtUtility jwtUtil;

//     public JwtTokenFilter(JwtUtility jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         String header = request.getHeader("Authorization");
//         if (header != null && header.startsWith("Bearer ")) {
//             String token = header.substring(7);
//             if (jwtUtil.validateToken(token)) {
//                 String username = jwtUtil.extractUsername(token);
//                 UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
//                 SecurityContextHolder.getContext().setAuthentication(authentication);
//             }
//         }
//         filterChain.doFilter(request, response);
//     }
// }
