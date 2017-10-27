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
import br.ufes.inf.s2cvv.core.domain.Community;
import br.ufes.inf.s2cvv.core.domain.Community_;

/**
 * TODO: document this type.
 *
 * @author
 * @version 1.0
 */
@Stateless
public class CommunityJPADAO extends BaseJPADAO<Community> implements CommunityDAO {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private static final Logger logger = Logger.getLogger(CommunityJPADAO.class.getCanonicalName());

	/** The application's persistent context provided by the application server. */
	@PersistenceContext
	private EntityManager entityManager;

	/** @see br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO#getEntityManager() */
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/** @see br.ufes.inf.s2cvv.core.persistence.AcademicDAO#retrieveByEmail(java.lang.String) */
	@Override
	public Community retrieveByName(String name) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Retrieving the community whose name is \"{0}\"...", name);

		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Community> cq = cb.createQuery(Community.class);
		Root<Community> root = cq.from(Community.class);

		// Filters the query with the email.
		cq.where(cb.equal(root.get(Community_.name), name));
		Community result = executeSingleResultQuery(cq, name);
		logger.log(Level.INFO, "Retrieve community by the name\"{0}\" returned \"{1}\"", new Object[] { name, result });
		return result;
	}
}
