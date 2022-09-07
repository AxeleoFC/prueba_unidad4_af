package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;
@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void ingresar(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Producto p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscar(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :datoCodigoBarras",
				Producto.class);
		myQuery.setParameter("datoCodigoBarras", codigoBarras);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Producto> buscarPorCategoria(String categoria) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Producto> myQuery = myCriteria.createQuery(Producto.class);
		
		Root<Producto> myTabla = myQuery.from(Producto.class);
		
		Predicate predicado = myCriteria.equal(myTabla.get("categoria"), categoria);// p.nombre = :datoNombre
		
		myQuery.select(myTabla).where(predicado);
		
		TypedQuery<Producto> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public boolean buscarProductoExistente(String codigoBarras) {
		// TODO Auto-generated method stub
		try {
			TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :datoCodigoBarras",
					Producto.class);
			myQuery.setParameter("datoCodigoBarras", codigoBarras);
			Producto p=myQuery.getSingleResult();
			
			if(p!=null) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Producto p");
		
		return jpqlQuery.getResultList();
	}

	@Override
	public Producto buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

}
