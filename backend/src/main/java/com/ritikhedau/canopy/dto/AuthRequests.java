package com.ritikhedau.canopy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AuthRequests {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRequest {
        private String email;
        private String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignUpRequest {
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String orgName;
    }

    @Data
    @AllArgsConstructor
    public static class JwtAuthenticationResponse {
        private String accessToken;
        private String tokenType = "Bearer";
        private UserSummary user;

        public JwtAuthenticationResponse(String accessToken, UserSummary user) {
            this.accessToken = accessToken;
            this.user = user;
        }
    }

    @Data
    @AllArgsConstructor
    public static class UserSummary {
        private Long id;
        private String email;
        private String firstName;
        private String lastName;
        private Long tenantId;
    }
// minor tweak: performance check updates
}

// minor tweak: update verification rules and configs
