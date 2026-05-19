package br.com.erivania.apibancaria.entity;

import br.com.erivania.apibancaria.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {

    public Usuario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    private boolean ativo = true;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Role getRole() {
        return role;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
