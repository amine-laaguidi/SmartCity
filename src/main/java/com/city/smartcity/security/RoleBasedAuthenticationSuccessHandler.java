package com.city.smartcity.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class RoleBasedAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response,
                          Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        clearAuthenticationAttributes(request);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "/admin";
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_ETUDIANT"))) {
            return "/etudiant";
        }  else if (authorities.contains(new SimpleGrantedAuthority("ROLE_AFFAIRE"))) {
            return "/affaire";
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_EMPLOI"))) {
            return "/emploi";
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_TOURISTE"))) {
            return "/tourisme";
        }else {
            throw new IllegalStateException("Unknown user role");
        }
    }
}
