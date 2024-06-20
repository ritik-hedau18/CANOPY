package com.ritikhedau.canopy.dto;

import lombok.Data;

public class TenantDto {

    @Data
    public static class CreateTenantRequest {
        private String name;
        private String slug;
    }
}
