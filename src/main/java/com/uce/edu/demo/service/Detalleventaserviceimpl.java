package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleVentaRepository;
import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Venta;
@Service
public class Detalleventaserviceimpl implements IDetalleVentaService {

	@Autowired
	private IVentaRepository ventaRepo;
	@Autowired
	private IDetalleVentaRepository detallesVentaRepo;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void IngresarDetalles(List<DetalleVenta> detalles, String numero) {
		// TODO Auto-generated method stub
		Venta v1=this.ventaRepo.buscar(numero);
		for(DetalleVenta d: detalles){
			d.setVenta(v1);
			this.detallesVentaRepo.ingresar(d);
		}
	}

}
