package eu.durcak.security2fa.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class OtpAuthSuccessHandler implements AuthenticationSuccessHandler {

    Logger logger = LoggerFactory.getLogger(OtpAuthSuccessHandler.class);
    private RedirectStrategy redirectStrategy;

    public OtpAuthSuccessHandler(){
        this.redirectStrategy = new DefaultRedirectStrategy();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        /*SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetailExtended userDetail = (UserDetailExtended) securityContext.getAuthentication().getPrincipal();*/
        UserDetailExtended userDetail = (UserDetailExtended) authentication.getPrincipal();

        if (userDetail.is2FaEnabled()) {
            // Presmerujte na stránku s formulárom pre TOTP
            redirectStrategy.sendRedirect(request, response, "/challenge");
        } else {
            userDetail.setChallengeCompleted(true);
            redirectStrategy.sendRedirect(request, response, "/");
        }

    }


}
