package br.ufes.inf.s2cvv.core.application;

import java.util.Date;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.s2cvv.core.domain.Community;
import br.ufes.inf.s2cvv.core.persistence.CommunityDAO;

@Stateless
@PermitAll
public class ManageCommunitiesServiceBean extends CrudServiceBean<Community> implements ManageCommunitiesService {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private CommunityDAO communityDAO;

	@Override
	public BaseDAO<Community> getDAO() {
		return communityDAO;
	}

	@Override
	protected Community validate(Community newEntity, Community oldEntity) {
		// New communities must have their creation date set
		Date now = new Date(System.currentTimeMillis());
		if (oldEntity == null) newEntity.setCreationDate(now);

		// All communities have their last update date set when persisted.
		newEntity.setUpdateDate(now);

		return newEntity;
	}
}
