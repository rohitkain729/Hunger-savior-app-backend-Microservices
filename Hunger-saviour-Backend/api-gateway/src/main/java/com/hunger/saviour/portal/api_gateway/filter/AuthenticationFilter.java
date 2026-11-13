package com.hunger.saviour.portal.api_gateway.filter;

import java.util.Objects;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import com.hunger.saviour.portal.api_gateway.proxy.AuthenticationProxy;
import com.hunger.saviour.portal.handlers.UnAuthorizedException;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
//@RequiredArgsConstructor
public class AuthenticationFilter
        extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
	
	private  RouteValidator validator;
	private   AuthenticationProxy authenticationProxy;
	
	public AuthenticationFilter(AuthenticationProxy authenticationProxy,RouteValidator validator) {
		super(Config.class);
		this.authenticationProxy=authenticationProxy;
		this.validator=validator;
	}

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> {

            // JWT validation logic will go here
        	log.info("Received Request :"+exchange.getRequest().toString());
        	
        	if(validator.publicEndPoints.test(exchange.getRequest())) {
        		
        		if(exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION)==null) {
        			
//        			throw new UnAuthorizedException("Missing Authorization Header");
        			
        			 ServerHttpResponse response = exchange.getResponse();

        			    response.setStatusCode(HttpStatus.UNAUTHORIZED);
        			    
        			    

        			    return response.setComplete();
        		}
        		
        		String authHeaders = Objects.requireNonNull(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);
        		
        		if(authHeaders!=null&&authHeaders.startsWith("Bearer ")) {
        			authHeaders = authHeaders.substring(7);
        		}
        		
        		log.info("Recived token"+authHeaders);
        		return  validateToken(authHeaders)
        				.flatMap(valid -> {
        					if(Boolean.TRUE.equals(valid)) {
        						log.info("valid token received");
        						return chain.filter(exchange);
        					}else {
        						log.info("Token validation failed");
        						ServerHttpResponse response = exchange.getResponse();
        						return response.setComplete();
        					}
        				});
        		
        	}

            return chain.filter(exchange);
        };
    }

    public static class Config {
    	
    	
    }
    
    private Mono<Boolean> validateToken(String token){
    	log.info("validating token"+token);
    	return authenticationProxy.validateToken(token);
    }
    
    
    
    
    
}