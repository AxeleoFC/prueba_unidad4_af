package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Venta;
@Repository
@Transactional
public class VentaRepositoryImpl implements IVentaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(Venta v) {
		// TODO Auto-generated method stub
		this.entityManager.persist(v);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Venta v) {
		// TODO Auto-generated method stub
		this.entityManager.merge(v);
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public Venta buscar(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Venta> myQuery = this.entityManager.createQuery("SELECT v FROM Venta v WHERE v.numero = :datoNumero",
				Venta.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Venta> buscarPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		TypedQuery<Venta> myQuery = this.entityManager.createQuery("SELECT v FROM Venta v WHERE v.fecha >= :datoFecha",
				Venta.class);
		myQuery.setParameter("datoFecha", fecha);
		
		List<Venta> ventas =myQuery.getResultList();
		for(Venta v: ventas) {
			v.getDetallesVentas().size();
		}
		
		return ventas;
	}

}
