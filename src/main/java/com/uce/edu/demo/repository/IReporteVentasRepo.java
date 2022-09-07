package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.ReporteventasTo;

public interface IReporteVentasRepo {
	
	public List<ReporteventasTo> reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad);

}
