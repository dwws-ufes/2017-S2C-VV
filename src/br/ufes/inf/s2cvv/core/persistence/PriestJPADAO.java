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
	public Priest retrieveByName(String name)
			throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the priest whose name is \"{0}\"...", name);

		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Priest> cq = cb.createQuery(Priest.class);
		Root<Priest> root = cq.from(Priest.class);

		// Filters the query with the email.
		cq.where(cb.equal(root.get(Priest_.name), name));
		Priest result = executeSingleResultQuery(cq, name);
		logger.log(Level.INFO, "Retrieve priest by the name\"{0}\" returned \"{1}\"", new Object[] { name, result });
		return result;
	}

}
