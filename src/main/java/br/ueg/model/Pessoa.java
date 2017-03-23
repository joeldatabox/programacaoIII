package br.ueg.model;

import br.ueg.model.enumeration.Sexo;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable, Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "sexo", columnDefinition = "enum('M','F')")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(name = "cpf", unique = true)
    @CPF(message = "ERRO AO VALIDAR CPF")
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome) {
        this();
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpr) {
        this.cpf = cpr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
