package br.ufes.inf.s2cvv.core.application;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.s2cvv.core.domain.Volunteer;
import br.ufes.inf.s2cvv.core.persistence.VolunteerDAO;

@Stateless
@PermitAll
public class ManageVolunteersServiceBean extends CrudServiceBean<Volunteer> implements ManageVolunteersService {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private VolunteerDAO volunteerDAO;

	@Override
	public BaseDAO<Volunteer> getDAO() {
		return volunteerDAO;
	}

	@Override
	protected Volunteer validate(Volunteer newEntity, Volunteer oldEntity) {
		// New volunteers must have their creation date set
		Date now = new Date(System.currentTimeMillis());
		if (oldEntity == null) newEntity.setCreationDate(now);

		// All volunteers have their last update date set when persisted.
		newEntity.setUpdateDate(now);

		return newEntity;
	}
}
