package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import entity.Persona;

@Stateless
public class PersonaFacade  extends AbstractFacade<Persona> {

	@PersistenceContext(unitName = "UlloaBermeo-IvanMarcelo-ExamenFinal")
	private EntityManager entityManager;
	
	public PersonaFacade() {
		super(Persona.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	public Persona searchPerson(String cedula){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> usuarioCriteriaQuery = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> usuarioRoot = usuarioCriteriaQuery.from(Persona.class);
        Predicate predicate= criteriaBuilder.equal(usuarioRoot.get("cedula"),cedula);
        usuarioCriteriaQuery.select(usuarioRoot).where(predicate);
        return entityManager.createQuery(usuarioCriteriaQuery).getSingleResult();
    }
	
}
