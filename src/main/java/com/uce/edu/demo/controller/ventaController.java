package com.uce.edu.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.IVentaService;

@Controller
@RequestMapping("/ventas")
public class ventaController {
	
	@Autowired
	private IProductoService productoService;
	@Autowired
	private
	IVentaService ventasService;
	
	@GetMapping("/vista")
	public String vista(Model modelo) {
		return "vistaVenta";
	}
	
	@GetMapping("/buscarProducto")
	public String buscarTodos(Model modelo) {
		List<Producto> lista=this.productoService.buscarTodos();
		modelo.addAttribute("productos", lista);
		return "vistaProductos";
	}
	
	@GetMapping("/nuevoProducto")
	public String paginaCrearrProducto(Producto producto, Model modelo) {
		modelo.addAttribute("producto", producto);
		return "vistaNuevoProducto";
	}
	
	@PostMapping("/insertarProducto")
	public String insertarProducto(Producto producto) {
		this.productoService.ingresarProducto(producto);
		return "redirect:/ventas/vista"; 
	}
	
	@GetMapping("/venderProducto/{idProducto}")
	public String paginaVenderProducto(@PathVariable("idProducto") Integer id, Model modelo) {
		System.out.println("El ID es: "+id);
		Producto producto=this.productoService.buscarId(id);
		modelo.addAttribute("producto", producto);
		return "vistaProductoVenta";
	}
	@PutMapping("/generarVenta/{idProducto}")
	public String VenderProducto(@PathVariable("idProducto") Integer id, Producto producto, Venta venta) {
		producto.setId(id);
		List<Producto> lista=new ArrayList<Producto>();
		lista.add(producto);
		this.ventasService.realizarVenta(lista, venta.getCedula(), venta.getNumero());
		return "redirect:/ventas/vista"; 
	}
	
	@GetMapping("/consultarProducto")
	public String paginaConsultarProducto(Producto producto, Model modelo) {
		modelo.addAttribute("producto", producto);
		return "vistaConsultarProducto";
	}
	
	@GetMapping("/buscarProducto")
	public String buscarProducto(Producto producto,Model modelo) {
		producto=this.productoService.buscar(producto.getCodigoBarras());
		modelo.addAttribute("producto", producto);
		return "vistaProductoBuscado";
	}
	/*
	@PostMapping("/insertarProductoVendido/{idPersona}")
	public String insertarProductoVendido(@PathVariable("idPproducto") Integer id) {
		this.productoService.ingresarProducto(producto);
		return "redirect:/ventas/vista"; 
	}
*/
}
