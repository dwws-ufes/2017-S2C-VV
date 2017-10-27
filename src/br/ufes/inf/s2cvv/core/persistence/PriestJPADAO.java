package br.ufes.inf.s2cvv.core.persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.s2cvv.core.domain.Priest;
import br.ufes.inf.s2cvv.core.domain.Priest_;

@Stateless
public class PriestJPADAO extends BaseJPADAO<Priest> implements PriestDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
	
	private static final Logger logger = Logger.getLogger(PriestJPADAO.class.getCanonicalName());

	@Override
	public Priest retrieveByEmail(String email)
			throws /*PersistentObjectNotFoundException, */MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the priest whose email is \"{0}\"...", email);

		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Priest> cq = cb.createQuery(Priest.class);
		Root<Priest> root = cq.from(Priest.class);

		// Filters the query with the email.
		cq.where(cb.equal(root.get(Priest_.email), email));
		Priest result;
		try {
			result = executeSingleResultQuery(cq, email);
		}
		catch(PersistentObjectNotFoundException e) {
			return null;
		}
		logger.log(Level.INFO, "Retrieve priest by the email\"{0}\" returned \"{1}\"", new Object[] { email, result });
		return result;
	}

}
