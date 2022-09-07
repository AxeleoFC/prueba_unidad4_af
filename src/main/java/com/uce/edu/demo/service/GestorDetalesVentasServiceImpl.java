package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleVentaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ReporteventasTo;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class GestorDetalesVentasServiceImpl implements IGestorDetalesVentasService {

	@Autowired
	private IVentaRepository ventaRepo;
	@Autowired
	private IDetalleVentaRepository detalleRepo;
	@Autowired
	private IDetalleVentaService detallesVentaService;
	@Autowired
	private IProductoRepository productoRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<ReporteventasTo> reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		List<Venta> venta=this.ventaRepo.buscarPorFecha(fecha);
		List<ReporteventasTo> reporte=new ArrayList<ReporteventasTo>();
		for(Venta v: venta) {
			for(DetalleVenta d: v.getDetallesVentas()) {
				ReporteventasTo r=new ReporteventasTo();
				Producto p=this.detalleRepo.buscarPorProducto(categoria);
				if(p.getCategoria().equals(categoria) && d.getCantidad()==cantidad) {
					r.setCantidad(d.getCantidad());
					r.setPrecioU(d.getPrecioUnitario());
					r.setSubTotal(d.getSubtotal());
					r.setCodBarras(p.getCodigoBarras());
					r.setNombreProducto(p.getNombre());
					reporte.add(r);
				}
			}
		}
		return reporte;
		
	}
}
