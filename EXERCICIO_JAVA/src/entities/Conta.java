package entities;

import java.util.Calendar;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table (name="CONTA_USUARIO")
public class Conta {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column (name="id_conta", nullable=false)
private int id_conta;
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Usuario.class)
    @JoinColumn(name = "ID_USUARIO", nullable = false, referencedColumnName = "id_usuario")
private Usuario nome;
    @Column
private String tipoConta;
    @ManyToOne (fetch = FetchType.LAZY, cascade= CascadeType.ALL, targetEntity= InfoBanco.class)
    @JoinColumn (name= "NOME_BANCO", nullable=false, referencedColumnName= "id_banco")
private InfoBanco nomeBanco;
    @Temporal(TemporalType.DATE)
    @Column
private Calendar dataAberturaConta;
@Column (name="NUM_CONTA", nullable=false, unique=true)    
private int numConta;
@Column
private double saldoConta;


	
	public Conta() {}
	
	public Conta (Usuario nome, String tipoConta, InfoBanco nomeBanco, Calendar dataAberturaConta, int numConta, double saldoConta) {
		this.nome=nome;
		this.tipoConta=tipoConta;
		this.nomeBanco=nomeBanco;
		this.dataAberturaConta=dataAberturaConta;
		this.numConta=numConta;
		this.saldoConta=saldoConta;
		
		
		
	}

	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}

	public Usuario getNome() {
		return nome;
	}

	public void setNome(Usuario nome) {
		this.nome = nome;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public InfoBanco getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(InfoBanco nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public Calendar getDataAberturaConta() {
		return dataAberturaConta;
	}

	public void setDataAberturaConta(Calendar dataAberturaConta) {
		this.dataAberturaConta = dataAberturaConta;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_conta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return id_conta == other.id_conta;
	}

}


