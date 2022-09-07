package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;

public interface IDetalleVentaRepository {
	
	public void ingresar(DetalleVenta dv);
	public void actualizar(DetalleVenta dv);
	public List<DetalleVenta> buscarPorVenta(String numero);
	public Producto buscarPorProducto(String codigoBarras);

}
