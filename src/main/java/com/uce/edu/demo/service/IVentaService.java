package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IVentaService {
	
	public void realizarVenta(List<Producto> productos, String cedula, String numeroventa);

}
