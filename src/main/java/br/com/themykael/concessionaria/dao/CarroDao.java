package br.com.themykael.concessionaria.dao;

import java.util.List;

import br.com.themykael.concessionaria.domain.Carro;

public interface CarroDao {
	
	void salvar(Carro carro);
	
	void editar(Carro carro);
	
	void excluir(Long id);
	
	Carro getId(Long id);
	
	List<Carro> getTodos();

}
