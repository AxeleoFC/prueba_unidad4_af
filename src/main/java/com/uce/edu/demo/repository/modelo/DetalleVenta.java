package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
	
	@Id
	@Column(name = "deta_vent_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deta_vent_id_seq")
	@SequenceGenerator(name = "deta_vent_id_seq", sequenceName = "deta_vent_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "deta_vent_cantidad")
	private Integer cantidad;
	
	@Column(name = "deta_vent_precio_unitario")
	private BigDecimal precioUnitario;
	
	@Column(name = "deta_vent_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name = "deta_vent_produ_id")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "deta_vent_venta_id")
	private Venta venta;

	@Override
	public String toString() {
		return "DetalleVenta [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", subtotal=" + subtotal + ", producto=" + producto +  "]";
	}

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}
