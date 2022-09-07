package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;
@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void ingresarProducto(Producto p) {
		// TODO Auto-generated method stub
		if(this.productoRepo.buscarProductoExistente(p.getCodigoBarras())){
			
			Producto productoExistente=this.productoRepo.buscar(p.getCodigoBarras());
			
			Integer antiguoStock=productoExistente.getStock();
			Integer nuevoStock=antiguoStock+p.getStock();
			productoExistente.setStock(nuevoStock);
			this.productoRepo.actualizar(productoExistente);
			
		}else {
			this.productoRepo.ingresar(p);
		}
	}

	@Override
	public Producto buscar(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscar(codigoBarras);
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarTodos();
	}

	@Override
	public Producto buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarId(id);
	}

}
