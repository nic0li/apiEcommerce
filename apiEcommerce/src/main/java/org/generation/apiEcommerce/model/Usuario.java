package org.generation.apiEcommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 1, max = 45)
	private String nome;
	
	@NotNull
	@Size(min = 1, max = 45)
	private String usuario;
	
	@NotNull
	@Size(min = 1, max = 45)
	private String senha;
	
	@ManyToMany
	@JoinTable(name = "tb_inscricao",
	joinColumns = @JoinColumn(name = "usuario_id"),
	inverseJoinColumns = @JoinColumn(name = "loja_id"))
	@JsonIgnoreProperties({"clientes", "pedido", "produto"})
	private List<Loja> lojasInscricoes;
	
	@OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("proprietario")
	private List<Loja> lojasProprietario;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Pedido> pedidosFeitos;
	
	//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Loja> getLojasInscricoes() {
		return lojasInscricoes;
	}

	public void setLojasInscricoes(List<Loja> lojasInscricoes) {
		this.lojasInscricoes = lojasInscricoes;
	}

	public List<Loja> getLojasProprietario() {
		return lojasProprietario;
	}

	public void setLojasProprietario(List<Loja> lojasProprietario) {
		this.lojasProprietario = lojasProprietario;
	}

	public List<Pedido> getPedidosFeitos() {
		return pedidosFeitos;
	}

	public void setPedidosFeitos(List<Pedido> pedidosFeitos) {
		this.pedidosFeitos = pedidosFeitos;
	}
	
	

}
