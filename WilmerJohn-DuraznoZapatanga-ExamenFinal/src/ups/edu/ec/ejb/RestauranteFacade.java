package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import entity.Persona;
import entity.Restaurante;

@Stateless
public class RestauranteFacade  extends AbstractFacade<Restaurante> {

	@PersistenceContext(unitName = "UlloaBermeo-IvanMarcelo-ExamenFinal")
	private EntityManager entityManager;
	
	public RestauranteFacade() {
		super(Restaurante.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	public Restaurante nombreRestaurante(String nombre) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Restaurante> usuarioCriteriaQuery = criteriaBuilder.createQuery(Restaurante.class);
        Root<Restaurante> usuarioRoot = usuarioCriteriaQuery.from(Restaurante.class);
        Predicate predicate= criteriaBuilder.equal(usuarioRoot.get("nombre"),nombre);
        usuarioCriteriaQuery.select(usuarioRoot).where(predicate);
        return entityManager.createQuery(usuarioCriteriaQuery).getSingleResult();
		
	}
	
}
