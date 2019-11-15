package br.com.meuprojeto.pedidoTeste.domain;

import java.math.BigDecimal;

public class Item {
	
	private Integer id;
	private String nome;
	private int qtd;
	private BigDecimal vlrUnitario;	
	private BigDecimal vlrTotal;
	
	public Item() {}
	
	public Item(Integer id, String cliente, int qtd, BigDecimal vlrUnitario, BigDecimal vlrTotal) {
		this.id = id;
		this.nome = nome;
		this.qtd = qtd;
		this.vlrUnitario = vlrUnitario;
		this.vlrTotal = vlrTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
