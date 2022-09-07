package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "venta")
public class Venta {
	
	@Id
	@Column(name = "venta_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venta_id_seq")
	@SequenceGenerator(name = "venta_id_seq", sequenceName = "venta_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "venta_numero")
	private String numero;
	
	@Column(name = "venta_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "venta_cedula_cliente")
	private String cedula;
	
	@Column(name = "venta_total_venta")
	private BigDecimal totalVenta;
	
	@OneToMany(mappedBy = "venta",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<DetalleVenta> detallesVentas;
	
	@Override
	public String toString() {
		return "Venta [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", cedula=" + cedula + ", totalVentas="
				+ totalVenta + ", detallesVentas=" + detallesVentas + "]";
	}

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<DetalleVenta> getDetallesVentas() {
		return detallesVentas;
	}

	public void setDetallesVentas(List<DetalleVenta> detallesVentas) {
		this.detallesVentas = detallesVentas;
	}

}
