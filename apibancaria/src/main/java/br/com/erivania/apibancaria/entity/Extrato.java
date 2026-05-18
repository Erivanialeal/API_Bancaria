package br.com.erivania.apibancaria.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Extrato {

    public Extrato() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "data_movimento", nullable = false)
    private LocalDateTime dataMovimento;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getDataMovimento() {
        return dataMovimento;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
