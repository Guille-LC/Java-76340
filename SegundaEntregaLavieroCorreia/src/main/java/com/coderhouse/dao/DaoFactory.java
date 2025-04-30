package com.coderhouse.dao;

import org.springframework.stereotype.Service;

import com.coderhouse.models.Cliente;
import com.coderhouse.models.Concesionaria;
import com.coderhouse.models.Gama;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class DaoFactory {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persistirCliente(Cliente cliente) {
		em.persist(cliente);
	};
	
	@Transactional
	public void persistirConcesionaria(Concesionaria coche) {
		em.persist(coche);
	};
	
	@Transactional
	public void persistirGama(Gama gama) {
		em.persist(gama);
	}
	
	@Transactional
	public Concesionaria getCocheById(Long cocheId) throws Exception {
		try {
			TypedQuery<Concesionaria> query = em.createQuery("SELECT c FROM Concesionaria c WHERE c.id = :id", Concesionaria.class);
			return query.setParameter("id", cocheId).getSingleResult();
		} catch(Exception err) {
			throw new Exception("El coche no existe");
		}
	}
	
	@Transactional
	public Gama getGamaById(Long gamaId) throws Exception {
		try {
			TypedQuery<Gama> query = em.createQuery("SELECT g FROM Gama g WHERE g.id = :id", Gama.class);
			return query.setParameter("id", gamaId).getSingleResult();
		} catch(Exception err) {
			throw new Exception("La gama no existe");
		}
	}
	
	@Transactional
	public void asignarGamaACoche(Long cocheId, Long gamaId) throws Exception {
		Concesionaria coche = getCocheById(cocheId);
		if (coche == null) {
			throw new Exception("El coche con ese ID no existe");
		}
		
		Gama gama = getGamaById(gamaId);
		if (gama == null) {
			throw new Exception("La gama con ese ID no existe");
		}
		
		coche.setGama(gama);
		em.merge(coche);
	}
}
