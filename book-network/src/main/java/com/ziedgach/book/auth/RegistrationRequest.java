package com.ziedgach.book.auth;

import com.ziedgach.book.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder

public class RegistrationRequest {

   @NotEmpty(message = "First name cannot be empty")
   @NotBlank(message = "First name cannot be empty")
    private String firstname;
    @NotEmpty(message = "Last name cannot be empty")
    @NotBlank(message = "Last name cannot be empty")
    private String lastname;
    @Email(message = "Invalid email address")
    @NotEmpty(message = "Email cannot be empty")
    @NotBlank(message = "Email name cannot be empty")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    @NotBlank(message = "Password name cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;




}
