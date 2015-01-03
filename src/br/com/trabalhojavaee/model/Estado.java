package br.com.trabalhojavaee.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ESTADO")
public class Estado extends BaseModel implements Serializable {

    private static final long serialVersionUID = -3064306490724801147L;

    @Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="nome")
	private String nome;

	@Column(name="sigla")
	private String sigla;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")  
	private List<Cidade> cidades;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	
//	public Cep getCep() {
//		return cep;
//	}
//	
//	public void setCep(Cep cep) {
//		this.cep = cep;
//	}

}
