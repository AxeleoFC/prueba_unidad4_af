package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReporteventasTo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codBarras;
	private String nombreProducto;
	private Integer Cantidad;
	private BigDecimal precioU;
	private BigDecimal subTotal;
	
	public ReporteventasTo() {
		// TODO Auto-generated constructor stub
	}
	
	public ReporteventasTo(String codBarras, String nombreProducto, Integer cantidad, BigDecimal precioU,
			BigDecimal subTotal) {
		super();
		this.codBarras = codBarras;
		this.nombreProducto = nombreProducto;
		Cantidad = cantidad;
		this.precioU = precioU;
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "ReporteventasTo [codBarras=" + codBarras + ", nombreProducto=" + nombreProducto + ", Cantidad="
				+ Cantidad + ", precioU=" + precioU + ", subTotal=" + subTotal + "]";
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public BigDecimal getPrecioU() {
		return precioU;
	}

	public void setPrecioU(BigDecimal precioU) {
		this.precioU = precioU;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	
	
}
