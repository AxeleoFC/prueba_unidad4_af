package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private IVentaRepository ventaRepo;
	@Autowired
	private IDetalleVentaService detallesVentaService;
	@Autowired
	private IProductoRepository productoRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarVenta(List<Producto> productos, String cedula, String numeroventa) {
		// TODO Auto-generated method stub
		Venta venta=new Venta();
		venta.setCedula(cedula);
		venta.setNumero(numeroventa);
		venta.setFecha(LocalDateTime.now());
		
		BigDecimal total=new BigDecimal(0);
		List<DetalleVenta> detalles=new ArrayList<DetalleVenta>();
		
		for(Producto p: productos) {
			Producto buscarProducto=this.productoRepo.buscar(p.getCodigoBarras());
			BigDecimal valor=new BigDecimal(0);
			DetalleVenta detalle=new DetalleVenta();
			
			if(buscarProducto.getStock()==0) {
				throw new RuntimeException();
			}else {
				if(buscarProducto.getStock()<=p.getStock()) {
					detalle.setCantidad(buscarProducto.getStock());
					valor.add(buscarProducto.getPrecio().multiply(new BigDecimal(buscarProducto.getStock())));
					detalle.setSubtotal(valor);
					buscarProducto.setStock(0);
					this.productoRepo.actualizar(buscarProducto);
				}else {
					detalle.setCantidad(buscarProducto.getStock()-p.getStock());
					valor.add(buscarProducto.getPrecio().multiply(new BigDecimal(buscarProducto.getStock()-p.getStock())));
					detalle.setSubtotal(valor);
					buscarProducto.setStock(buscarProducto.getStock()-p.getStock());
					this.productoRepo.actualizar(buscarProducto);
				}
			}
			detalle.setProducto(buscarProducto);
			detalle.setPrecioUnitario(buscarProducto.getPrecio());
			total.add(valor);
			detalles.add(detalle);
		}
		venta.setTotalVenta(total);
		this.ventaRepo.ingresar(venta);
		
		this.detallesVentaService.IngresarDetalles(detalles, numeroventa);
		
	}

}
