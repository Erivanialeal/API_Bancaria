package br.com.erivania.apibancaria.service;

import java.net.PasswordAuthentication;

import org.springframework.stereotype.Service;

import br.com.erivania.apibancaria.entity.Cliente;
import br.com.erivania.apibancaria.entity.Usuario;
import br.com.erivania.apibancaria.enums.Role;
import br.com.erivania.apibancaria.repository.ClienteRepository;
import br.com.erivania.apibancaria.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private PasswordAuthentication passwordAuthentication;
    private ClienteRepository clienteRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordAuthentication passwordAuthentication,
            ClienteRepository clienteRepository) {
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.passwordAuthentication = passwordAuthentication;
    }

    public Usuario criarUsuario(Usuario usuario, Cliente cliente) {
        validarEmail(usuario.getEmail());
        validarSenha(usuario.getSenha());
        validarRelacionamentoCliente(cliente);
        verificarEmailExistente(usuario.getEmail());
        definirRole(usuario);
        definirStatus(usuario);
        associarCliente(usuario, cliente);

        return usuarioRepository.save(usuario);

    }

    private void validarEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new RuntimeException("Email Obrigatorio");
        }
        email.trim();

        if (!email.contains("@") || !email.contains(".")) {
            throw new RuntimeException("Email inválido!");
        }
        if (email.length() > 100) {
            throw new RuntimeException("Email muito longo!");
        }
    }

    private void validarSenha(String senha) {
        if (senha == null || senha.isBlank()) {
            throw new RuntimeException("Senha obrigatoria!");
        }

        if (senha.length() > 6 || senha.length() < 6) {
            throw new RuntimeException("Senha deve possuir exatamente 6 caracteres!");
        }

        boolean possuiLetra = false;
        boolean possuiNumero = false;
        for (int i = 0; i < senha.length(); i++) {
            if (Character.isLetter(senha.charAt(i))) {
                possuiLetra = true;

            }
            if (Character.isDigit(senha.charAt(i))) {
                possuiNumero = true;
            }
        }
        if (!possuiLetra) {
            throw new RuntimeException("Erro: senha precisa conter letra!");
        }
        if (!possuiNumero) {
            throw new RuntimeException("Erro: senha precisa conter número!");
        }
    }

    private void validarRelacionamentoCliente(Cliente cliente) {
        if (cliente == null) {
            throw new RuntimeException("Clinete não pode ser vazio!");

        }
        if (!clienteRepository.existsById(cliente.getId())) {
            throw new RuntimeException("Cliente não existe no sistema!");
        }

    }

    private void verificarEmailExistente(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("Email já cadastrado");
        }
    }

    private void definirRole(Usuario usuario) {
        // todo usuario novo nasce como cliente
        usuario.setRole(Role.ROLE_CLIENTE);
    }

    private void definirStatus(Usuario usuario) {
        usuario.setAtivo(true);

    }

    private void associarCliente(Usuario usuario, Cliente cliente) {
        usuario.setCliente(cliente);
    }

}
