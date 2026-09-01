package com.mvmmoreira.apilogincadastro.service;

import com.mvmmoreira.apilogincadastro.dto.request.CadastroRequest;
import com.mvmmoreira.apilogincadastro.dto.request.LoginRequest;
import com.mvmmoreira.apilogincadastro.dto.response.UsuarioResponse;
import com.mvmmoreira.apilogincadastro.exception.CredenciaisInvalidasException;
import com.mvmmoreira.apilogincadastro.exception.UsuarioJaExisteException;
import com.mvmmoreira.apilogincadastro.model.Usuario;
import com.mvmmoreira.apilogincadastro.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponse cadastrar (CadastroRequest request){
        if(usuarioRepository.findByEmail(request.getEmail()).isPresent()){
            throw new UsuarioJaExisteException("Ja existe um usuario cadastrado com esse email");
        }
        if(usuarioRepository.findByCpf(request.getCpf()).isPresent()){
            throw new UsuarioJaExisteException("Ja existe um usuario com esse cpf");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setCpf(request.getCpf());
        usuario.setEmail(request.getEmail());
        usuario.setDataNascimento(request.getDataNascimento());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioResponse(usuarioSalvo.getId(), usuarioSalvo.getEmail());
    }

    public UsuarioResponse autenticar(LoginRequest request){
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CredenciaisInvalidasException("Email ou senha invalidos"));

        if(!passwordEncoder.matches(request.getSenha(), usuario.getSenha())){
            throw new CredenciaisInvalidasException("Email ou senha invalidos");
        }

        return new UsuarioResponse(usuario.getId(), usuario.getEmail());
    }
}
