package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.service.JwtService;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    public AuthenticationController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(
            @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authorizationHeader) {

        Credentials credentials = decodeBasicCredentials(authorizationHeader);
        if (credentials == null || !"user".equals(credentials.username()) || !"pwd".equals(credentials.password())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = jwtService.generateToken(credentials.username());
        return ResponseEntity.ok(Map.of("token", token));
    }

    private Credentials decodeBasicCredentials(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
            return null;
        }

        try {
            String encodedValue = authorizationHeader.substring(6);
            String decodedValue = new String(Base64.getDecoder().decode(encodedValue), StandardCharsets.UTF_8);
            int separatorIndex = decodedValue.indexOf(':');

            if (separatorIndex == -1) {
                return null;
            }

            String username = decodedValue.substring(0, separatorIndex);
            String password = decodedValue.substring(separatorIndex + 1);
            return new Credentials(username, password);
        } catch (IllegalArgumentException exception) {
            return null;
        }
    }

    private record Credentials(String username, String password) {
    }
}
