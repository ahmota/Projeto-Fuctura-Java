package dao.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.ContaDao;
import entities.Conta;
import util.JpaUtil;

public class ContaDaoImpl implements ContaDao {
  EntityManager em= JpaUtil.getEntityManager();
	
@Override
	public void transferencia(Conta saldoConta, double valorTransfer, Conta outraConta) {
		if (saldoConta.getSaldoConta()>= valorTransfer) {
	
		
		
			try {
				em.getTransaction().begin();
				saldoConta.setSaldoConta(saldoConta.getSaldoConta()-valorTransfer);
				outraConta.setSaldoConta(outraConta.getSaldoConta()+valorTransfer);
				em.merge(saldoConta);
				em.merge(outraConta);
				em.getTransaction().commit();
			} catch (Exception e) {
				System.out.println(e);
				em.getTransaction().rollback();
			} finally {
				em.close();
				
			}
		
			
		}else {
			System.out.println("Saldo insuficiente");
		}
}
	

	@Override
	public Conta buscarConta(int numConta) {
		
			
			
			Query query=em.createQuery("SELECT c FROM Conta c WHERE NUM_CONTA="+ numConta, Conta.class);
			
			Conta conta = (Conta) query.getSingleResult();
			if (conta==null) {
				System.out.println("Conta inexstente");
				
				
			}
			return conta;

					
	}
		
	

	@Override
	public void depositar(Conta contaDepositar, double valorDepositar) {
		try {
			em.getTransaction().begin();
			contaDepositar.setSaldoConta(contaDepositar.getSaldoConta()+valorDepositar);
			
			em.merge(contaDepositar);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void sacar(Double valorSaque, Conta saldoConta) {
		if (saldoConta.getSaldoConta()<= valorSaque) {
			
			
			
			try {
				em.getTransaction().begin();
				saldoConta.setSaldoConta(saldoConta.getSaldoConta()-valorSaque);
				
				em.merge(saldoConta);
				
				em.getTransaction().commit();
			} catch (Exception e) {
				System.out.println(e);
				em.getTransaction().rollback();
			} finally {
				em.close();
				
			}
		
			
		}else {
			System.out.println("Saldo insuficiente");
		
		}
	}

	@Override
	public List<Conta> listarTodos() {
		TypedQuery<Conta> listaConta=em.createQuery("SELECT c FROM Conta c",Conta.class);
		return listaConta.getResultList();
	}

	@Override
	public Conta pesquisarPorId( Integer id) {
	 Conta pesquisarConta=em.find(Conta.class, id);
		
		return pesquisarConta;
	}

	@Override
	public Conta atualizar(Conta object, int id) {
		try {
			em.getTransaction().begin();
			Conta conta=pesquisarPorId(id);
			conta.setNome(object.getNome());
			conta.setNomeBanco(object.getNomeBanco());
			conta.setTipoConta(object.getTipoConta());
			em.merge(conta);
			em.getTransaction().commit();
		}catch(Exception e) {
			
		}
		
		return null;
	}

	@Override
	public void delete(Conta object) {
		try {
			em.getTransaction().begin();
			em.remove(object.getId_conta());
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
    @Override
	public void inserir (Conta object) {
    	try {
			em.getTransaction().begin();
			em.persist(object);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e);
		}	
	}
}
