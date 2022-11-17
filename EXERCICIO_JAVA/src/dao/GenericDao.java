package dao;

import java.util.List;

public interface GenericDao <A> {
	
	
	
    public List<A> listarTodos();
    
    public A pesquisarPorId( Integer id);
	
	public A atualizar(A object,int id);
	
	public void inserir (A object);
	
	public void delete(A object);


}
