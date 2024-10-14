package br.unitins.tp1.placadevideo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente extends DefaultEntity{

@Column(length = 60, nullable = false )
private String nome;

@Column(length = 60, nullable = false )
private String cpf;

private LocalDate dataNascimento;

private String email;

@OneToMany(cascade = CascadeType.ALL)

private List<Endereco> enderecos;

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

public LocalDate getDataNascimento() {
    return dataNascimento;
}

public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public List<Endereco> getEnderecos() {
    return enderecos;
}

public void setEnderecos(List<Endereco> enderecos) {
    this.enderecos = enderecos;
}

}
