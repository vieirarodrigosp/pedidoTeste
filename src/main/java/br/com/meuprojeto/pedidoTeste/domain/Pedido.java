package br.com.meuprojeto.pedidoTeste.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
	
	private Integer id;
	private String cliente;
	private LocalDateTime dt;
	private BigDecimal vlrTotal; 
	private List<Item> items;
	
	public Pedido() {}
	
	public Pedido(Integer id, String cliente, LocalDateTime dt, BigDecimal vlrTotal, List<Item> items) {
		this.id = id;
		this.cliente = cliente;
		this.dt = dt;
		this.vlrTotal = vlrTotal;
		this.items = items; 
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public LocalDateTime getDt() {
		return dt;
	}
	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}
	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}
	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
