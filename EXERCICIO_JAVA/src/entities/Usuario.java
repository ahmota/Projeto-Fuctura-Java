package entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="DADOS_USUARIO")
public class Usuario {

  @Id
  @GeneratedValue(strategy= GenerationType.SEQUENCE)
  @Column
  private int id_usuario;
  @Column
  private String nome;
  @Column(name="CNPJ", nullable=true, unique=true)
  private String cnpj;
  @Column(name="CPF", nullable=true, unique=true)
  private String cpf;
  
  public Usuario() {}
  
  public Usuario (String nome, String cnpj, String cpf) {
  this.nome=nome;
  this.cnpj=cnpj;
  this.cpf=cpf;
  }

public int getId_usuario() {
	return id_usuario;
}

public void setId_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCnpj() {
	return cnpj;
}

public void setCnpj(String cnpj) {
	this.cnpj = cnpj;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

@Override
public int hashCode() {
	return Objects.hash(id_usuario);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Usuario other = (Usuario) obj;
	return id_usuario == other.id_usuario;
}
  
}
