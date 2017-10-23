package br.ufes.inf.s2cvv.core.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.s2cvv.core.domain.Priest;

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

}
