package br.ufes.inf.s2cvv.core.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.s2cvv.core.domain.Volunteer;

@Stateless
public class VolunteerJPADAO extends BaseJPADAO<Volunteer> implements VolunteerDAO {

	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
	// TODO Auto-generated method stub
	return entityManager;
}
}
