package com.ziedgach.book.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationRequest {

    @Email(message = "Invalid email address")
    @NotEmpty(message = "Email cannot be empty")
    @NotBlank(message = "Email name cannot be empty")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    @NotBlank(message = "Password name cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

}
