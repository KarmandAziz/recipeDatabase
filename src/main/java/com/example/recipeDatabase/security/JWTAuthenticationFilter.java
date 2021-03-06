package com.example.recipeDatabase.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        setFilterProcessesUrl("/api/v1/public/auth");
    }

    @Override
    public org.springframework.security.core.Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        LoginCommand loginCommand;
        try{
            loginCommand = new ObjectMapper().readValue(request.getInputStream(), LoginCommand.class);
        }catch (IOException ex){
            throw new AuthenticationCredentialsNotFoundException("Missing credentials");
        }

        if(loginCommand != null && loginCommand.getUsername() != null && loginCommand.getPassword() != null){
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginCommand.getUsername(), loginCommand.getPassword()
                    )
            );
        }else {
            throw new BadCredentialsException("Bad credentials");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException {

        AppUserDetails appUserDetails = (AppUserDetails) authResult.getPrincipal();

        if(appUserDetails != null){
            String jwt = jwtUtil.fromAppUserDetails(appUserDetails);
            Map<String, String> body = new HashMap<>();
            body.put("accessToken", jwt);
            ObjectMapper objectMapper = new ObjectMapper();

            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
            response.getWriter().write(json);
        }
    }


}