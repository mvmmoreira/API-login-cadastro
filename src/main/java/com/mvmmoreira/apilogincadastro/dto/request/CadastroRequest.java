package com.mvmmoreira.apilogincadastro.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CadastroRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 digitos numericos")
    private String cpf;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve sr valido")
    private String email;

    @NotNull(message = "Data de Nascimento  é obrigatório")
    @Past(message = "Data de nascimento deve estar no passado")
    private LocalDate dataNascimento;

    @NotBlank(message = "Senha  é obrigatório")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).{6,}$",
            message = "Senha deve ter no mínimo 6 caracteres, incluindo letras e números")
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
