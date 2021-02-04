package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import entity.Persona;
import entity.Reserva;
import entity.Restaurante;

@Stateless
public class ReservaFacade extends AbstractFacade<Reserva> {

	@PersistenceContext(unitName = "UlloaBermeo-IvanMarcelo-ExamenFinal")
	private EntityManager entityManager;
	
	public ReservaFacade() {
		super(Reserva.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	public List<Reserva> clienteReserva(Persona persona) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reserva> criteriaQuery = criteriaBuilder.createQuery(Reserva.class);
        
        Root<Reserva> categoriaRoot= criteriaQuery.from(Reserva.class);
        Predicate predicate= criteriaBuilder.equal(categoriaRoot.get("persona"),persona);
        criteriaQuery.select(categoriaRoot).where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
		
	}
	
	 public List<Reserva> restauranteReserva(Restaurante restaurante) {
		 
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reserva> criteriaQuery = criteriaBuilder.createQuery(Reserva.class);
        
        Root<Reserva> categoriaRoot= criteriaQuery.from(Reserva.class);
        Predicate predicate= criteriaBuilder.equal(categoriaRoot.get("restaurante"),restaurante);
        criteriaQuery.select(categoriaRoot).where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
		 
	 }
	
	 public List<Reserva> fechaReserva(Restaurante restaurante, String fecha) {
		 
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reserva> criteriaQuery = criteriaBuilder.createQuery(Reserva.class);
        
        Root<Reserva> categoriaRoot= criteriaQuery.from(Reserva.class);
        Predicate predicate= criteriaBuilder.equal(categoriaRoot.get("restaurante"),restaurante);
        Predicate predicate2= criteriaBuilder.equal(categoriaRoot.get("fecha"),fecha);
        Predicate[] predicates = new Predicate[]{predicate, predicate2};
        
        criteriaQuery.select(categoriaRoot).where(predicates);
        return entityManager.createQuery(criteriaQuery).getResultList();
		 
	 }
	 
}
