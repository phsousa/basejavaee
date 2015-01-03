package br.com.trabalhojavaee.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.trabalhojavaee.dao.CidadeDao;
import br.com.trabalhojavaee.model.Cidade;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CidadeService {

	@EJB
	private CidadeDao cidadeDao;
	
	public CidadeDao getCidadeDao() {
		return cidadeDao;
	}

	public void setCidadeDao(CidadeDao cidadeDao) {
		this.cidadeDao = cidadeDao;
	}

	public void salvarCidade(Cidade cidade)  {
		
		if(cidade != null){
			List<Cidade> listaCidade = cidade.getEstado().getCidades();
			int tamanho = listaCidade.size() + 1;
			cidade.setId(new Long(tamanho));
			listaCidade.add(cidade);
		}
	}
	
	public void editarCidade(Cidade cidade)  {
		if(cidade != null){
			List<Cidade> listaCidade = cidade.getEstado().getCidades();
		}
	}

	public void excluirCidade(Cidade cidade) {
		cidadeDao.excluirCidade(cidade);
	}

	public Cidade selecionar(Cidade cidade) {
		return cidadeDao.selecionar(cidade);
	}

	public List<Cidade> selecionarTodos() {
		return cidadeDao.selecionarTodos();
	}
	
}
