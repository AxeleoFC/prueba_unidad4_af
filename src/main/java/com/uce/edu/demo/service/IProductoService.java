package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoService {
	
	public void ingresarProducto(Producto p);
	public Producto buscar(String codigoBarras);
	public List<Producto> buscarTodos();
	public Producto buscarId(Integer id);

}
