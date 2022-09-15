package dominio;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_T8_Empresa")
public class Empresa {
	
	@Id
	@Column(name = "cd_empresa", nullable = false)
	private Integer codigo;
	
	@Column(name = "nm_empresa", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "ds_cnpj", length = 50, nullable = false)
	private String cnpj;
	
	@Column(name = "ds_empresa", length = 50)
	private String descricao;
	
	@Column(name = "ds_email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "ds_senha", length = 50, nullable = false)
	private String senha;
	
	@Column(name = "dt_compra", nullable = false)
	private LocalDate dataCompra;
	
	@Column(name = "ds_vl_compra", length = 15, nullable = false)
	private int valorCompra;
	
	@Column(name = "ds_status_compra", length = 50)
	private String statusCompra;

	
	public Empresa() {
		
	}
	
	public Empresa(Integer codigo, String nome, String cnpj, String descricao, String email, String senha,
			LocalDate dataCompra, int valorCompra, String statusCompra) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.descricao = descricao;
		this.email = email;
		this.senha = senha;
		this.dataCompra = dataCompra;
		this.valorCompra = valorCompra;
		this.statusCompra = statusCompra;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public int getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(int valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getStatusCompra() {
		return statusCompra;
	}

	public void setStatusCompra(String statusCompra) {
		this.statusCompra = statusCompra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, codigo, dataCompra, descricao, email, nome, senha, statusCompra, valorCompra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(dataCompra, other.dataCompra) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && Objects.equals(statusCompra, other.statusCompra)
				&& valorCompra == other.valorCompra;
	}
	
	
	
}
