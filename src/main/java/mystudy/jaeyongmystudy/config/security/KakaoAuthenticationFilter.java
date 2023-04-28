package mystudy.jaeyongmystudy.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@RequiredArgsConstructor
public class KakaoAuthenticationFilter extends GenericFilterBean {

    private final KakaoTokenProvider kakaoTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 헤더에 존재하는 토큰만 따로 파싱하기, 직접 만든 provider에서 해당 메소드 만들기.
        String token = kakaoTokenProvider.resolveToken((HttpServletRequest) request);
        // 헤더에 토큰이 있는지 확인
        // 토큰이 비어있지 않다면 이후 토큰에서 유저 정보를 가져올때 유효성 검사를 하게 됨, jwt 라면 유효성 검사를 따로 분리해서 하는 것이 좋을 것 같다.
        if (token != null) {

            // 직접 만든 provider에서 토큰안에 저장되어 있는 정보를 바탕으로 userdetail 객체를 가져온 다음 SecurityContext 에 Authentication 객체를 저장.
            Authentication authentication = kakaoTokenProvider.getAuthentication(token);
            System.out.println("토큰 가져옴");
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}
