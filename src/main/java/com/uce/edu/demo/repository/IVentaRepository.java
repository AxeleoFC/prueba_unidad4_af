package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Venta;

public interface IVentaRepository {
	
	public void ingresar(Venta v);
	public void actualizar(Venta v);
	public Venta buscar(String numero);

	public List<Venta> buscarPorFecha(LocalDateTime fecha);
}
