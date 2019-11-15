package br.com.meuprojeto.pedidoTeste.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private Integer codigoTabela;
	private Integer id;
	private Integer idPedido;
	private String nome;
	private int qtd;
	private BigDecimal vlrUnitario;	
	private BigDecimal vlrTotal;
	
	public ItemEntity() {}
	
	public ItemEntity(Integer id, Integer idPedido, String nome, int qtd, BigDecimal vlrUnitario, BigDecimal vlrTotal) {
		this.id = id;
		this.idPedido = idPedido;
		this.nome = nome;
		this.qtd = qtd;
		this.vlrUnitario = vlrUnitario;
		this.vlrTotal = vlrTotal;
	}

	public Integer getCodigoTabela() {
		return codigoTabela;
	}

	public void setCodigoTabela(Integer codigoTabela) {
		this.codigoTabela = codigoTabela;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getVlrUnitario() {
		return vlrUnitario;
	}

	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}

	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}
}
