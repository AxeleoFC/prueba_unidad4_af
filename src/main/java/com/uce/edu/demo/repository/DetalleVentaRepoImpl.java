package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
@Repository
@Transactional
public class DetalleVentaRepoImpl implements IDetalleVentaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(DetalleVenta dv) {
		// TODO Auto-generated method stub
		this.entityManager.persist(dv);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(DetalleVenta dv) {
		// TODO Auto-generated method stub
		this.entityManager.merge(dv);
	}

	@Override
	public List<DetalleVenta> buscarPorVenta(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<DetalleVenta> myQuery = this.entityManager.createQuery("SELECT dv FROM DetalleVenta dv WHERE dv.venta.numero = :datoNumero",
				DetalleVenta.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getResultList();
	}

	@Override
	public Producto buscarPorProducto(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM DetalleVenta dv, Producto p WHERE dv.producto.codigoBarras = :datoCodigoBarras",
				Producto.class);
		myQuery.setParameter("datoCodigoBarras", codigoBarras);
		return myQuery.getSingleResult();
	}


}
