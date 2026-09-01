package com.mvmmoreira.apilogincadastro.controller;


import com.mvmmoreira.apilogincadastro.dto.request.CadastroRequest;
import com.mvmmoreira.apilogincadastro.dto.request.LoginRequest;
import com.mvmmoreira.apilogincadastro.dto.response.UsuarioResponse;
import com.mvmmoreira.apilogincadastro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioResponse> cadastrar(@Valid @RequestBody CadastroRequest request){
        UsuarioResponse response = usuarioService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponse> autenticar(@Valid @RequestBody LoginRequest request){
        UsuarioResponse response = usuarioService.autenticar(request);
        return ResponseEntity.ok(response);
    }
}
