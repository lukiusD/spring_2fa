package eu.durcak.security2fa.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TwoFactorAuthenticationFilter  extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetailExtended) {
            UserDetailExtended userDetails = (UserDetailExtended) authentication.getPrincipal();

            // Skontrolujte stav 2FA
            if (!userDetails.isChallengeCompleted() && !request.getRequestURI().equals("/challenge")) {
                response.sendRedirect("/challenge");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
