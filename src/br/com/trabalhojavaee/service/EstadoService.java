package br.com.trabalhojavaee.service;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.context.FacesContext;

import br.com.trabalhojavaee.dao.EstadoDao;
import br.com.trabalhojavaee.model.Cidade;
import br.com.trabalhojavaee.model.Estado;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class EstadoService {

	@EJB
	private EstadoDao estadoDao;

	public void setEstadoDao(EstadoDao estadoDao) {
		this.estadoDao = estadoDao;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void excluirEstado(Estado estado) {
		try {
			estadoDao.excluirEstado(estado);
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvarEstado(Estado estado) {
		try {
			if (estado.getCidades() != null) {
				for (Cidade cidade : estado.getCidades()) {
					Double populacao = cidade.getPopulacao().doubleValue();
					if (populacao.compareTo(cidade.getPib()) > 0) {
						//throw new PibInvalidoException();
					}
				}
			}
			estadoDao.salvarEstado(estado);
			FacesContext.getCurrentInstance().getExternalContext().redirect("estados.xhtml");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Estado selecionar(Estado estado) {
		return estadoDao.selecionar(estado);
	}
	
	public List<Estado> selecionarTodos() {
		return estadoDao.selecionarTodos();
	}

}
