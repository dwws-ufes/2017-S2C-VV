package br.ufes.inf.s2cvv.core.persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.s2cvv.core.domain.Volunteer;
import br.ufes.inf.s2cvv.core.domain.Volunteer_;

@Stateless
public class VolunteerJPADAO extends BaseJPADAO<Volunteer> implements VolunteerDAO {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	private static final Logger logger = Logger.getLogger(VolunteerJPADAO.class.getCanonicalName());

	@Override
	public Volunteer retrieveByEmail(String email)
			throws MultiplePersistentObjectsFoundException, PersistentObjectNotFoundException {
		logger.log(Level.FINE, "Retrieving the volunteer whose email is \"{0}\"...", email);

		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Volunteer> cq = cb.createQuery(Volunteer.class);
		Root<Volunteer> root = cq.from(Volunteer.class);

		// Filters the query with the email.
		cq.where(cb.equal(root.get(Volunteer_.email), email));
		Volunteer result = executeSingleResultQuery(cq, email);
		logger.log(Level.INFO, "Retrieve volunteer by the email\"{0}\" returned \"{1}\"", new Object[] { email, result });
		return result;
	}
}
