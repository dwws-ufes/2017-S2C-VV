package br.ufes.inf.s2cvv.core.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.s2cvv.core.application.ManageVolunteersService;
import br.ufes.inf.s2cvv.core.domain.Volunteer;

@Named
@SessionScoped
public class ManageVolunteersController extends CrudController<Volunteer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageVolunteersService manageVolunteersService;

	@Override
	protected CrudService<Volunteer> getCrudService() {
		return manageVolunteersService;
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageVolunteers.filter.byName", "name", getI18nMessage("msgsCore", "manageVolunteers.text.filter.byName")));
	}
	
//	@Override
//	protected void prepEntity() {
//		// TODO Auto-generated method stub
//		super.prepEntity();
//	}
}
