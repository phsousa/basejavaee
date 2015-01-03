package br.com.trabalhojavaee.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.trabalhojavaee.model.Estado;
import br.com.trabalhojavaee.service.EstadoService;

@ManagedBean (name="estadoMB")
@RequestScoped
public class EstadoMB {
	@EJB
	private EstadoService estadoService;
	private List<Estado> estados;
	private Estado estado = new Estado();

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}
	
	@PostConstruct
	public void inicializar() {
		estados = estadoService.selecionarTodos();
	}

	public String novo() {
		estado = new Estado();
		return "estadosEditar";
	}

	public String salvar() {
		estadoService.salvarEstado(estado);
		inicializar();
		return "estados";
	}

	public String excluir() {
		estadoService.excluirEstado(estado);
		estados = estadoService.selecionarTodos();
		return "estados";
	}
	
}