package br.ufes.inf.s2cvv.core.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.inf.s2cvv.core.application.ManagePriestsService;
import br.ufes.inf.s2cvv.core.domain.Priest;

@Named
@SessionScoped
public class ManagePriestsController extends CrudController<Priest> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManagePriestsService managePriestsService;

	@Override
	protected CrudService<Priest> getCrudService() {
		return managePriestsService;
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("managePriests.filter.byName", "name", getI18nMessage("msgsCore", "managePriests.text.filter.byName")));
	}
	
}
