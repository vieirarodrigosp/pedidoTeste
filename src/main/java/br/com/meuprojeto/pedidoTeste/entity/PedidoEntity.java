package br.com.meuprojeto.pedidoTeste.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class PedidoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private Integer codigoTabela;
	private Integer id;
	private String cliente;
	private LocalDateTime dt;
	private BigDecimal vlrTotal; 
	
	public PedidoEntity() {}
	
	public PedidoEntity(Integer id, String cliente, LocalDateTime dt, BigDecimal vlrTotal) {
		this.id = id;
		this.cliente = cliente;
		this.dt = dt;
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
}
