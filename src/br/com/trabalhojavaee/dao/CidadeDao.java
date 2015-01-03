package br.com.trabalhojavaee.dao;

import java.util.List;

import javax.ejb.Stateless;

import br.com.trabalhojavaee.model.Cidade;

@Stateless
public class CidadeDao extends GenericDao<Cidade> {

	public void salvarCidade(Cidade cidade) {
		if(cidade.getId() != null) {
			super.atualizarEntidade(cidade); 
		} else {
			super.inserirEntidade(cidade);
		}
	}
	
	public List<Cidade> selecionarTodos() {
		return super.selecionarTodos();
	}
	
	public Cidade selecionar(Cidade cidade) {
		return super.selecionarEntidade(cidade);
	}
	
	public void excluirCidade(Cidade cidade) {
		super.excluirEntidade(cidade);
	}

	@Override
	protected Class<Cidade> getClasseEntidade() {
		return Cidade.class;
	}
}
