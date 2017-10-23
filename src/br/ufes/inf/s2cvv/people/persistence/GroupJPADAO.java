package br.ufes.inf.s2cvv.people.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.s2cvv.people.domain.Group;

@Stateless
public class GroupJPADAO  extends BaseJPADAO<Group> implements GroupDAO{

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return entityManager;
	}

}
