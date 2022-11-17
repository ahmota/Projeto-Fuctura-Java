package entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="DADOS_BANCO")
public class InfoBanco {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column	
	private int id_banco;
	@Column
	private String nomebanco;
	@Column (name="CNPJ", nullable=false, unique=true)
	private String cnpj;
	@Column
    private String email;
	@Column
	private String enderecoBanco;

	public InfoBanco() {
		
	}
	public InfoBanco (String nomebanco, String cnpj, String email, String enderecoBanco) {
		this.nomebanco=nomebanco;
		this.cnpj=cnpj;
		this.email=email;
		this.enderecoBanco= enderecoBanco;
		
	}

	public int getId_banco() {
		return id_banco;
	}
	public void setId_banco(int id_banco) {
		this.id_banco = id_banco;
	}
	public String getNomebanco() {
		return nomebanco;
	}
	public void setNomebanco(String nome) {
		this.nomebanco = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnderecoBanco() {
		return enderecoBanco;
	}
	public void setEndereçoUsuario(String enderecoBanco) {
		this.enderecoBanco = enderecoBanco;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_banco);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoBanco other = (InfoBanco) obj;
		return id_banco == other.id_banco;
	}
		}

		



