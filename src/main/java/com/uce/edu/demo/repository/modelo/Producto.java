package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@Column(name = "produ_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produ_id_seq")
	@SequenceGenerator(name = "produ_id_seq", sequenceName = "produ_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "produ_cod_barras")
	private String codigoBarras;
	
	@Column(name = "produ_nombre")
	private String nombre;
	
	@Column(name = "produ_categoria")
	private String categoria;
	
	@Column(name = "produ_stock")
	private Integer stock;
	
	@Column(name = "produ_precio")
	private BigDecimal precio;
	
	@OneToMany(mappedBy = "producto",fetch = FetchType.LAZY)
	private List<DetalleVenta> detallesVentas;
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", categoria="
				+ categoria + ", stock=" + stock + ", precio=" + precio + "]";
	}

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleVenta> getDetallesVentas() {
		return detallesVentas;
	}

	public void setDetallesVentas(List<DetalleVenta> detallesVentas) {
		this.detallesVentas = detallesVentas;
	}

}
