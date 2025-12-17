package ru.mishgan325.docsa.pr8.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // 1. Получаем текущую аутентификацию из SecurityContext
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                // 2. Если это JWT токен
                if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
                    // 3. Достаем сам токен (строку)
                    String tokenValue = jwtAuthenticationToken.getToken().getTokenValue();
                    
                    // 4. Добавляем заголовок Authorization в запрос к CustomerService
                    template.header("Authorization", "Bearer " + tokenValue);
                }
            }
        };
    }
}
