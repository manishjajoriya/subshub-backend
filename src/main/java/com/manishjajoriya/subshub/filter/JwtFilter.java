package com.manishjajoriya.subshub.filter;

import com.manishjajoriya.subshub.config.CustomUserDetails;
import com.manishjajoriya.subshub.config.CustomUserDetailsService;
import com.manishjajoriya.subshub.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {
  private final CustomUserDetailsService customUserDetailsService;
  private final JwtUtil jwtUtil;

  public JwtFilter(CustomUserDetailsService customUserDetailsService, JwtUtil jwtUtil) {
    this.customUserDetailsService = customUserDetailsService;
    this.jwtUtil = jwtUtil;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    String authorizationHeader = request.getHeader("Authorization");
    String uid = null;
    String jwt = null;
    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      jwt = authorizationHeader.substring(7);
      uid = jwtUtil.extractUsername(jwt);

      if (uid != null) {
        CustomUserDetails userDetail =
            (CustomUserDetails) customUserDetailsService.loadUserById(UUID.fromString(uid));
        if (jwtUtil.validateToken(jwt)) {
          UsernamePasswordAuthenticationToken auth = new
              UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
          auth.setDetails(userDetail);
          SecurityContextHolder.getContext().setAuthentication(auth);
        }
      }

    }
    filterChain.doFilter(request, response);
  }
}
