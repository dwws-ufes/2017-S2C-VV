package br.ufes.inf.s2cvv.core.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.inf.s2cvv.core.domain.S2CVVConfiguration;
import br.ufes.inf.s2cvv.core.domain.S2CVVConfiguration_;

@Stateless
public class S2CVVConfigurationJPADAO extends BaseJPADAO<S2CVVConfiguration> implements S2CVVConfigurationDAO {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(S2CVVConfigurationJPADAO.class.getCanonicalName());
	
	@Override
	public S2CVVConfiguration retrieveCurrentConfiguration() throws PersistentObjectNotFoundException {
		logger.log(Level.FINE, "Retrieving current (latest) S2CVV configuration...");

		// Constructs the query over the S2CVVConfiguration class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<S2CVVConfiguration> cq = cb.createQuery(S2CVVConfiguration.class);
		Root<S2CVVConfiguration> root = cq.from(S2CVVConfiguration.class);

		// Orders the query descending by date.
		cq.orderBy(cb.desc(root.get(S2CVVConfiguration_.creationDate)));

		// Retrieves and returns the latest configuration (first entity returned). If the query returns an empty list,
		// throws an exception.
		List<S2CVVConfiguration> result = entityManager.createQuery(cq).getResultList();
		try {
			S2CVVConfiguration cfg = result.get(0);
			logger.log(Level.INFO, "Retrieve current configuration returned a S2CVVConfiguration with parish \"{0}\" and creation date \"{1}\"", new Object[] { cfg.getParishAcronym(), cfg.getCreationDate() });
			return cfg;
		}
		catch (IndexOutOfBoundsException e) {
			throw new PersistentObjectNotFoundException(e, getDomainClass());
		}
	}
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}
}
