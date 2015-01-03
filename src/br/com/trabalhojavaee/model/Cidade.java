package br.com.trabalhojavaee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CIDADE")
public class Cidade extends BaseModel implements Serializable {

    private static final long serialVersionUID = -3064306490724801147L;

    @Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="nome")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dataConstituicao")
	private String dataConstituicao;
	
	@Column(name="populacao")
	private Long populacao;

	@Column(name="pib")
	private Double pib;

	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado estado;

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

	public String getDataConstituicao() {
		return dataConstituicao;
	}

	public void setDataConstituicao(String dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}

	public Long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}

	public Double getPib() {
		return pib;
	}

	public void setPib(Double pib) {
		this.pib = pib;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
}
