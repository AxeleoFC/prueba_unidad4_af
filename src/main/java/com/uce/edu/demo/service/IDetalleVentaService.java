package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

public interface IDetalleVentaService {

	public void IngresarDetalles(List<DetalleVenta> detalles, String numero);
}
