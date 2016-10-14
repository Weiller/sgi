package br.com.sgi.model.interfaces;

import java.util.List;

public interface Dao<PK, T> {

	public void persistir(T entidade);
	
	public void atualizar(T entidade);
	
	public List<T> listarTodos();

	public T obterPorId(PK pk);
		
}
