package mystudy.jaeyongmystudy.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final KakaoTokenProvider kakaoTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.httpBasic().disable() // 기본 인증창 끄기
                .authorizeHttpRequests()  // 아래의 Requests에 대한 승인을 확인한다.
                .requestMatchers("/logintest").authenticated() // 이 주소로 왔을 때 확인해라
                .requestMatchers("/**").permitAll() // 나머지 주소는 그냥 다 승인해줘라
                .and()
                .addFilterBefore(new KakaoAuthenticationFilter(kakaoTokenProvider), UsernamePasswordAuthenticationFilter.class)
                // UsernamePasswordAuthenticationFilter.class 돌기 전에 내가 만든 필터에서 카카오 토큰을 확인하고 가라.
                .build();
    }


}
