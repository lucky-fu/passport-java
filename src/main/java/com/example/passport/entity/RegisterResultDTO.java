package com.example.passport.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResultDTO {
    @JsonProperty("user_id")
    private String userId;
    private String token;
}
