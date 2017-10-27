package br.ufes.inf.s2cvv.core.application;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.s2cvv.core.domain.Priest;
import br.ufes.inf.s2cvv.core.persistence.PriestDAO;

@Stateless
@PermitAll
public class ManagePriestsServiceBean extends CrudServiceBean<Priest> implements ManagePriestsService {

	private static final long serialVersionUID = 1L;
	@EJB
	private PriestDAO priestDAO;

	@Override
	public BaseDAO<Priest> getDAO() {
		return priestDAO;
	}

	@Override
	protected Priest validate(Priest newEntity, Priest oldEntity) {
		// New priests must have their creation date set
		Date now = new Date(System.currentTimeMillis());
		if (oldEntity == null) newEntity.setCreationDate(now);

		// All priests have their last update date set when persisted.
		newEntity.setUpdateDate(now);

		return newEntity;
	}
}
