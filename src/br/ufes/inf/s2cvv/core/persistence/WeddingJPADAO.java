package br.ufes.inf.s2cvv.core.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.s2cvv.core.domain.Wedding;

public class WeddingJPADAO extends BaseJPADAO<Wedding> implements WeddingDAO {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
