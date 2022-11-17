package dao;
import entities.Conta;


public interface ContaDao extends GenericDao <Conta> {
	
	
	
	public void transferencia (Conta saldoConta, double valorTransfer, Conta outraConta);
		
	
	
	public Conta buscarConta(int numConta);
		
	
	
	public void depositar (Conta contaDepositar, double valorDepositar);
	
	public void sacar (Double valorSaque, Conta saldoConta);
		
	

}
