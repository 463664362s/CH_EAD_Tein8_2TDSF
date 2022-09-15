package dominio;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_T8_Aplicacao")
public class Aplicacao {

	
	@Id
	@Column(name = "cd_aplicacao", length = 4, nullable = false)
	private Integer codigo;
	
	@Column(name = "nm_aplicacao", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "nr_botoes", length = 4, nullable = false)
	private Integer botoes;
	
	@Column(name = "nr_entrada_dados", nullable = false)
	private Integer entradaDados;
	
	@Column(name = "nr_links", length = 4, nullable = false)
	private Integer links;
	
	@ManyToOne
	@JoinColumn(name = "cd_empresa",nullable = false)
	private Empresa empresa;

	
	public Aplicacao() {
		
	}
	
	public Aplicacao(Integer codigo, String nome, Integer botoes, Integer entradaDados, Integer links, Empresa empresa) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.botoes = botoes;
		this.entradaDados = entradaDados;
		this.links = links;
		this.empresa = empresa;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getBotoes() {
		return botoes;
	}

	public void setBotoes(Integer botoes) {
		this.botoes = botoes;
	}

	public Integer getEntradaDados() {
		return entradaDados;
	}

	public void setEntradaDados(Integer entradaDados) {
		this.entradaDados = entradaDados;
	}

	public Integer getLinks() {
		return links;
	}

	public void setLinks(Integer links) {
		this.links = links;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(botoes, codigo, empresa, entradaDados, links, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aplicacao other = (Aplicacao) obj;
		return Objects.equals(botoes, other.botoes) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(empresa, other.empresa) && Objects.equals(entradaDados, other.entradaDados)
				&& Objects.equals(links, other.links) && Objects.equals(nome, other.nome);
	}
	
	
}
