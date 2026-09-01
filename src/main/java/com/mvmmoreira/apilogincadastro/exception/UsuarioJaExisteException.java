package com.mvmmoreira.apilogincadastro.exception;

public class UsuarioJaExisteException extends RuntimeException {
    public  UsuarioJaExisteException(String mensagem){
        super(mensagem);
    }
}
