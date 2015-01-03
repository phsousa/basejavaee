package br.com.trabalhojavaee.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.trabalhojavaee.model.Cidade;
import br.com.trabalhojavaee.model.Estado;
import br.com.trabalhojavaee.service.CidadeService;

@ManagedBean (name="cidadeMB")
@RequestScoped
public class CidadeMB {

	@EJB
    private CidadeService cidadeService;
	private List<Cidade> cidades;
	private Cidade cidade = new Cidade();
    private Estado estado = new Estado();
    

    public List<Cidade> getListaCidades() {
        return cidadeService.selecionarTodos();
    }
    
    @PostConstruct
	public void inicializar() {
		cidades = cidadeService.selecionarTodos();
	}

	public String novo() {
		cidade = new Cidade();
        cidade.setEstado(this.estado);
        return "cidadesEditar";
	}

	public String salvar() {
		cidadeService.salvarCidade(cidade);
		inicializar();
        return "estadosEditar";
	}
        
    public String editar() {
		cidadeService.editarCidade(cidade);
        return "estadosEditar";
    }
    
    public String preparaEditar() {
    	return "cidadesEditar";
    }
    
    public String preparaEditarEstadoCidade(Estado estado) {
    	this.estado = estado;
    	return "estadosEditar";
    }
    
    public String excluir() {
        cidadeService.excluirCidade(cidade);
        return "estadosEditar";
    }
    
    public void exibir() {
        cidade = cidadeService.selecionar(cidade);
    }

	public CidadeService getCidadeService() {
		return cidadeService;
	}

	public void setCidadeService(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}