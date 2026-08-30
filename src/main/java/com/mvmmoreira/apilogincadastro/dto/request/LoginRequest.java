package com.mvmmoreira.apilogincadastro.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class LoginRequest {

    @NotBlank(message = "Campo Email obrigatorio")
    @Email(message = "Necessario um email valido")
    private String email;

    @NotBlank(message = "Campo de senha obrigatorio")
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
