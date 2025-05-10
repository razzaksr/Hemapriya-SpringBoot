package microservice.four.api_gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

@Component
public class MyAuthenticationFilter extends AbstractGatewayFilterFactory<MyAuthenticationFilter.Config>{
    public static class Config{}

    public MyAuthenticationFilter(){super(Config.class);}

    @Autowired
    JwtService service;

    @Override
    public GatewayFilter apply(Config config) {
        // TODO Auto-generated method stub
        return (exchange,chain)->{
            String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
            if(authHeader==null || !authHeader.startsWith("Bearer ")){
                return Mono.error(new RuntimeException("Missing Bearer Header"));
            }
            try{
                String token = authHeader.substring(7);
                Claims claims = service.validateToken(token).getBody();
                exchange.getRequest().mutate().header("username",claims.getSubject());
            }
            catch(Exception ex){
                return Mono.error(new RuntimeException("Invalid Jwt Token"));
            }
            return chain.filter(exchange);
        };
    }
    
}
