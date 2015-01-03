package br.com.trabalhojavaee.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.trabalhojavaee.model.Estado;

@Stateless
public class EstadoDao extends GenericDao<Estado> {

	public void salvarEstado(Estado estado) {
		if(estado.getId() != null) {
			super.atualizarEntidade(estado); 
		} else {
			super.inserirEntidade(estado);
		}
	}
	
	public List<Estado> selecionarTodos() {
		return super.selecionarTodos();
	}
	
	public Estado selecionar(Estado estado) {
		return super.selecionarEntidade(estado);
	}
	
	public void excluirEstado(Estado estado) {
		super.excluirEntidade(estado);
	}

	@Override
	protected Class<Estado> getClasseEntidade() {
		return Estado.class;
	}
}
