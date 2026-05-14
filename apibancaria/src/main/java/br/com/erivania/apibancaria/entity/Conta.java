package br.com.erivania.apibancaria.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.DialectOverride.GeneratedColumn;

import br.com.erivania.apibancaria.enums.ContasEnums.StatusConta;
import br.com.erivania.apibancaria.enums.ContasEnums.TipoConta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_conta", nullable = false, unique = true, length = 20

    )
    private String numeroConta;

    @Column(name = "agencia", nullable = false, length = 20)
    private String agencia;

    @Column(name = "tipo_conta", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column(name = "saldo", nullable = false, precision = 10, scale = 2)
    private BigDecimal saldo;

    @Column(name = "limite_credito", nullable = false, precision = 10, scale = 2)
    private BigDecimal limiteCredito;

    @Column(name = "status_conta", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private StatusConta statusConta;

    @ManyToOne
    @JoinColumn(name = "cliente_id") // chave estrageira
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public StatusConta getStatusConta() {
        return statusConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

}
